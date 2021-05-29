package com.upgrad.capstone.controllers;

import com.upgrad.capstone.dto.OrderDTO;
import com.upgrad.capstone.entities.eshopOrder;
import com.upgrad.capstone.exceptions.*;
import com.upgrad.capstone.services.AddressService;
import com.upgrad.capstone.services.OrderService;
import com.upgrad.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class OrderControler<ProductService, ModelMapper>
{
    @Autowired
    AddressService addressService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @PostMapping(value="/products",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newOrder(@RequestBody int AddressId , int ProductId , @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException, BadCredentialsException, UserDetailsNotFoundException, AddressDetailsNotFoundException, ProductDetailsNotFoundException, UserDetailsNotFoundException, AddressDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");
        if(userService.getUserDetailsByUsername(token).getRole().equalsIgnoreCase("Admin"))
            throw new BadCredentialsException("This feature is only available to admin");
        if(AddressId<=0 || addressService.getAddressDetails(AddressId)==null)
            throw new AddressDetailsNotFoundException("Address details not found form this id pleace enter id");
        if(ProductId<=0 || productService.getProductDetails(ProductId)==null)
            throw new ProductDetailsNotFoundException("product not found from this id pleace enter valid id");
        eshopOrder newOrder=new eshopOrder();
        newOrder.setAmount(productService.getProductDetails(ProductId).getPrice());
        newOrder.setShippingAddressId(addressService.getAddressDetails(AddressId));
        newOrder.setUserId(userService.getUserDetailsByUsername(token));
        newOrder.setProductProductID(productService.getProductDetails(ProductId));
        newOrder.setOrderDate(LocalDateTime.now());
        orderService.acceptOrderDetails(newOrder);
        OrderDTO savedOrderDTO = modelMapper.map(newOrder, OrderDTO.class);
        return new ResponseEntity<>(savedOrderDTO, HttpStatus.CREATED);

    }

}
