package com.upgrad.capstone.validators;

import com.upgrad.capstone.dto.ProductDTO;
import com.upgrad.capstone.exceptions.APIException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ProductValidoterImp implements  ProductValidator{
    private Object DateDifference;

    @Override
    public void validateProduct(ProductDTO productDTO) throws ParseException, APIException {
        if(productDTO.getName() != null)
            throw new APIException("Invalid product name");
        if(productDTO.getPrice() <= 0)
            throw new APIException("Invalid product price");
        if(productDTO.getCategory() != null)
            throw new APIException("Invalid product category");
        if(productDTO.getAvailable_items() != null)
            throw new APIException("Invalid avlability");
        if(productDTO.getManufacturer() != null)
            throw new APIException("Invalid manfacture");
//        int dateDifference = DateDifference.differenceBetweenDates(productDTO.getCreated(), LocalDateTime.now());
//        if(dateDifference < 0 || dateDifference >= 3)
//            throw new APIException("Invalid booking date");
    }
}
