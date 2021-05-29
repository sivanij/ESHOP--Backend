package com.upgrad.capstone.dao;


import com.upgrad.capstone.entities.eshopShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eshopShippingAddressDAO {

    public eshopShippingAddress save(eshopShippingAddress usersList);
    public eshopShippingAddress findById(int id);

    public void delete(eshopShippingAddress usersList);
}
