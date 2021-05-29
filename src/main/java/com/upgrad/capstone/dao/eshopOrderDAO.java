package com.upgrad.capstone.dao;

import com.upgrad.capstone.entities.eshopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eshopOrderDAO  {


    public eshopOrder save(eshopOrder usersList);
    public eshopOrder findById(int id);


    public void delete(eshopOrder usersList);
}
