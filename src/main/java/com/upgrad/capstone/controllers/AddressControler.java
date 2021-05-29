package com.upgrad.capstone.controllers;

import com.upgrad.capstone.dto.AddressDTO;
import com.upgrad.capstone.entities.eshopShippingAddress;
import com.upgrad.capstone.exceptions.APIException;
import com.upgrad.capstone.services.AddressService;
import com.upgrad.capstone.services.UserService;
import com.upgrad.capstone.validators.AddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
@RestController
public class AddressControler<ModelMapper> {
    @Autowired
    AddressValidator addressValidator;
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value="/user-address",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAddress(@RequestBody AddressDTO addressDTO, @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException, UserDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");

        eshopShippingAddress newaddress = modelMapper.map(addressDTO, eshopShippingAddress.class);
        eshopShippingAddress savedAddress = addressService.acceptAddressDetails(newaddress);
        AddressDTO savedAddressDTO = modelMapper.map(savedAddress, AddressDTO.class);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }

}
