package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.OrderDTO;
import com.upgrad.capstone.exceptions.APIException;

import java.text.ParseException;

public interface OrderValidator {

    public void validateOrder(OrderDTO orderDTO) throws ParseException, APIException;
}
