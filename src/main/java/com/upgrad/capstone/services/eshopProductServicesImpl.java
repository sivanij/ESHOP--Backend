package com.upgrad.capstone.services;

import com.upgrad.capstone.dao.eshopProductDAO;
import com.upgrad.capstone.entities.eshopProduct;
import com.upgrad.capstone.exceptions.AddressDetailsNotFoundException;
import com.upgrad.capstone.exceptions.ProductDetailsNotFoundException;

import java.util.List;

public class eshopProductServicesImpl implements eshopProductServices{

    private eshopProductDAO productDao;
    @Override
    public eshopProduct acceptProductDetails(eshopProduct product) throws ProductDetailsNotFoundException, AddressDetailsNotFoundException {
        return productDao.save(product);
    }

    @Override
    public eshopProduct getProductDetails(int id) throws ProductDetailsNotFoundException {
        return productDao.findById(id);
    }

    @Override
    public eshopProduct updateProductDetails(int id, eshopProduct product) throws ProductDetailsNotFoundException {
        eshopProduct newproduct = getProductDetails(id);
        if (isNotNullOrZero(product.getName())) {
            newproduct.setName(product.getName());
        }
        if (isNotNullOrZero(product.getCategory())) {
            newproduct.setCategory(product.getCategory());
        }
        if (isNotNullOrZero(product.getAvailableItems())) {
            newproduct.setAvailableItems(product.getAvailableItems());
        }
        if (isNotNullOrZero(product.getCreated())) {
            newproduct.setCreated(product.getCreated());
        }
        if (isNotNullOrZero(product.getDescription())) {
            newproduct.setDescription(product.getDescription());
        }
        if (isNotNullOrZero(product.getImageUrl())){
            newproduct.setImageUrl(product.getImageUrl());
        }
        if (isNotNullOrZero(product.getManufacturer())) {
            newproduct.setManufacturer(product.getManufacturer());
        }
        if (isNotNullOrZero(product.getPrice())) {
            newproduct.setPrice(product.getPrice());
        }
        if (isNotNullOrZero(product.getUpdated())) {
            newproduct.setUpdated(product.getUpdated());
        }
        return productDao.save(newproduct);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    @Override
    public boolean deleteProduct(int id) throws ProductDetailsNotFoundException {
        eshopProduct product=getProductDetails(id);
        productDao.delete(product);
        return true;
    }

    @Override
    public List<eshopProduct> getAllProductsDetails() {
        return null;
    }

    @Override
    public List<String> getallCategory() {
        return null;
    }
}
