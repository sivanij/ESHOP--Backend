package com.upgrad.capstone.controllers;

import com.upgrad.capstone.dto.LoginDTO;
import com.upgrad.capstone.dto.UserDTO;
import com.upgrad.capstone.entities.eshopUser;
import com.upgrad.capstone.exceptions.*;
import com.upgrad.capstone.services.UserService;
import com.upgrad.capstone.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserService customerService;
    @Autowired
    UserValidator customerValidator;

    @PostMapping(value = "/auth/register",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody UserDTO userDTO)
            throws APIException, UserNameAlreadyExistException, UserDetailsNotFoundException, CustomException {

        customerValidator.validateUser(userDTO);
        try {
            eshopUser customer = customerService.getUserDetailsByUsername(userDTO.getUser_name());
            if (customer != null && customer.getFirstName()!=null) {
                throw new UserNameAlreadyExistException(
                        "Customer username name can't blank already exists for : " + customer.getFirstName());
            }
        } catch (UserDetailsNotFoundException | UserNameAlreadyExistException ex) {
            System.out.println("Customer does not exist for the given details");
        }

        try {
            eshopUser customer = customerService.getUserDetailsByUsername(userDTO.getUser_name());

            if (customer.getPhoneNumber() != null && customer.getPhoneNumber().length()==10) {
                throw new UserNameAlreadyExistException(
                        "please enter valid mobil nomber : " + customer.getPhoneNumber());
            }
        } catch (UserDetailsNotFoundException | UserNameAlreadyExistException ex) {
            System.out.println("Customer does not exist for the given details");
        }
        try {
            eshopUser customer = customerService.getUserDetailsByUsername(userDTO.getUser_name());

            if (customer.getEmail() != null && customer.getEmail().contains("@gmail.com")==true) {
                throw new UserNameAlreadyExistException(
                        "please enter valid gmail id : " + customer.getPhoneNumber());
            }
        } catch (UserDetailsNotFoundException | UserNameAlreadyExistException ex) {
            System.out.println("Customer does not exist for the given details");
        }
        try {
            Map<String, String> model = new HashMap<>();
            String username = userDTO.getUser_name();
            String password = userDTO.getPassword();
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                model.put("Error", "Username is invalid/ Password is empty");
                return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
            }
            eshopUser newCustomer = modelMapper.map(userDTO,eshopUser.class);
            eshopUser savedCustomer = customerService.acceptUserDetails(newCustomer);
            UserDTO savedCustomerDTO = modelMapper.map(savedCustomer,UserDTO.class);
            return new ResponseEntity<>(savedCustomerDTO,HttpStatus.CREATED);
        } catch (Exception e) {
            throw new CustomException("Username " + userDTO.getUser_name() + " already registered",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO)
            throws APIException, UserDetailsNotFoundException, CustomException, BadCredentialsException {
        customerValidator.validateUserLogin(loginDTO);
        Map<String, String> model = new HashMap<>();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.put("Error", "Username is invalid/ Password is empty");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }
        eshopUser savedCustomer = customerService.getUserDetailsByUsername(username);
        if (!savedCustomer.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid username/password");
        }
        model.put("message","Logged in Successfully");
        model.put("token",savedCustomer.getPassword());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
