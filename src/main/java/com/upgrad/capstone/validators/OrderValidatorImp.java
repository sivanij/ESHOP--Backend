package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.OrderDTO;
import com.upgrad.capstone.exceptions.APIException;

import java.text.ParseException;
import java.time.LocalDateTime;

public class OrderValidatorImp implements OrderValidator{
    private Object DateDifference;

    @Override
    public void validateOrder(OrderDTO orderDTO) throws ParseException, APIException {
        if(orderDTO.getId() <= 0)
            throw new APIException("Invalid userId");
        if(orderDTO.getProduct_product_id()<= 0)
            throw new APIException("Invalid number of product");
        if(orderDTO.getShipping_address_id() <= 0)
            throw new APIException("Invalid AddressID");
//        int dateDifference = DateDifference.differenceBetweenDates
//                (orderDTO.getOrder_date(), LocalDateTime.now());
//        if(dateDifference < 0 || dateDifference >= 3)
//            throw new APIException("Invalid booking date");
    }
}
