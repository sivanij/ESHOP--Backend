package com.upgrad.capstone.dao;

import com.upgrad.capstone.entities.eshopUser;

import java.util.List;

public interface eshopUserDAO  {
    public List<eshopUser> findByFirstName(String firstName);
    public List<eshopUser> findByLastName(String lastName);
    public List<eshopUser>  findByEmail(String email);
    public List<eshopUser> findByMobileNumber(String mobileNumber);
    public eshopUser save(eshopUser usersList);
    public eshopUser findById(int id);

    public void delete(eshopUser usersList);

    eshopUser findByUsername(String username);
}
