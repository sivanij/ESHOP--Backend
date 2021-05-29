package com.upgrad.capstone.services;

import com.upgrad.capstone.entities.eshopUser;
import com.upgrad.capstone.exceptions.UserDetailsNotFoundException;
import com.upgrad.capstone.exceptions.UserNameAlreadyExistException;
import com.upgrad.capstone.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {
    public eshopUser acceptUserDetails(eshopUser user) throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException;
    public eshopUser getUserDetails(int id) throws UserDetailsNotFoundException;
    public eshopUser getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;
    public eshopUser updateUserDetails(int id, eshopUser user) throws UserNameAlreadyExistException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;

}
