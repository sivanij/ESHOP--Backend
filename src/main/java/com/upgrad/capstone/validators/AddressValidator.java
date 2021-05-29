package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.AddressDTO;
import com.upgrad.capstone.exceptions.APIException;

import java.text.ParseException;

public interface AddressValidator {
    public void validateAddress(AddressDTO addressDTO) throws ParseException, APIException;

}
