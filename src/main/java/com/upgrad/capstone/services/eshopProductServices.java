package com.upgrad.capstone.services;

import com.upgrad.capstone.entities.eshopProduct;
import com.upgrad.capstone.exceptions.AddressDetailsNotFoundException;
import com.upgrad.capstone.exceptions.ProductDetailsNotFoundException;

import java.util.List;

public interface eshopProductServices {
    public eshopProduct acceptProductDetails(eshopProduct product) throws ProductDetailsNotFoundException, AddressDetailsNotFoundException;
    public eshopProduct getProductDetails(int id) throws ProductDetailsNotFoundException;
    public eshopProduct updateProductDetails(int id, eshopProduct product) throws ProductDetailsNotFoundException;
    public boolean deleteProduct(int id) throws ProductDetailsNotFoundException;
    public List<eshopProduct> getAllProductsDetails();
    public List<String> getallCategory();
}
