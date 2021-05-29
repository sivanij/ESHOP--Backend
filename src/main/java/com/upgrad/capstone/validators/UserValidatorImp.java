package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.LoginDTO;
import com.upgrad.capstone.dto.UserDTO;
import com.upgrad.capstone.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImp implements UserValidator{

    @Override
    public void validateUser(UserDTO userDTO) throws APIException {
        if(userDTO.getUser_name() == null || userDTO.getUser_name().length() <= 0)
            throw new APIException("Invalid username");
        if(userDTO.getFirst_name() == null || userDTO.getFirst_name().length() <= 0 )
            throw new APIException("Invalid firstname");
        if(userDTO.getLast_name() == null || userDTO.getLast_name().length() <= 0 )
            throw new APIException("Invalid lastname");
        if(userDTO.getPassword() == null || userDTO.getPassword().length() <= 0   )
            throw new APIException("Invalid password");
        if(userDTO.getCreated() == null)
            throw new APIException("Invalid date of birth");
        if(userDTO.getRole() == "Admin" || userDTO.getRole() == "User")
            throw new APIException("Invalid user type");
    }


    @Override
    public void validateUserLogin(LoginDTO user) throws APIException {
        if (user.getUsername() == null || user.getUsername().length() <= 0) {
            throw new APIException("Invalid username");
        }
        if(user.getPassword() == null || user.getPassword().length() <= 0   ) {
            throw new APIException("Invalid password");
        }
    }
}
