package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.LoginDTO;
import com.upgrad.capstone.dto.UserDTO;
import com.upgrad.capstone.exceptions.APIException;

public interface UserValidator {

    public void validateUser(UserDTO userDTO) throws APIException;
    public void validateUserLogin(LoginDTO loginDTO) throws APIException;
}
