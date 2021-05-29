package com.upgrad.capstone.dao;

import com.upgrad.capstone.entities.eshopProduct;


public interface eshopProductDAO {
    public eshopProduct save(eshopProduct usersList);
    public eshopProduct findById(int id);

    public void delete(eshopProduct usersList);
}
