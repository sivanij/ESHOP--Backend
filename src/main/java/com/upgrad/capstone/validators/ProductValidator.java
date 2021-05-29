package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.ProductDTO;
import com.upgrad.capstone.exceptions.APIException;

import java.text.ParseException;

public interface ProductValidator {
    public void validateProduct(ProductDTO productDTO) throws ParseException, APIException;

}
