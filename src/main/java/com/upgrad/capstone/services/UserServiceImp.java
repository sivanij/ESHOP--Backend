package com.upgrad.capstone.services;

import com.upgrad.capstone.dao.eshopUserDAO;
import com.upgrad.capstone.entities.eshopUser;
import com.upgrad.capstone.exceptions.UserDetailsNotFoundException;
import com.upgrad.capstone.exceptions.UserNameAlreadyExistException;
import com.upgrad.capstone.exceptions.UserTypeDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private eshopUserDAO userDAO;
    @Override
    public eshopUser acceptUserDetails(eshopUser user) throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException {
        return userDAO.save(user);
    }

    @Override
    public eshopUser getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDAO.findById(id);
    }

    @Override
    public eshopUser getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        return userDAO.findByUsername(username);
    }

    @Override
    public eshopUser updateUserDetails(int id, eshopUser user) throws UserNameAlreadyExistException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException {

        eshopUser newuser=getUserDetails(id);
        if (isNotNullOrZero(user.getFirstName())) {
            newuser.setFirstName(user.getFirstName());
        }
        if (isNotNullOrZero(user.getLastName())) {
            newuser.setLastName(user.getLastName());
        }
        if (isNotNullOrZero(user.getCreated())) {
            newuser.setCreated(user.getCreated());
        }
        if (isNotNullOrZero(user.getUpdated())) {
            newuser.setUpdated(user.getUpdated());
        }
        if (isNotNullOrZero(user.getEmail())) {
            newuser.setEmail(user.getEmail());
        }
        if (isNotNullOrZero(user.getUserName())) {
            newuser.setUserName(user.getUserName());
        }
        if (isNotNullOrZero(user.getPassword())) {
            newuser.setFirstName(user.getPassword());
        }
        if (isNotNullOrZero(user.getPhoneNumber())) {
            newuser.setPhoneNumber(user.getPhoneNumber());
        }
        if (isNotNullOrZero(user.getRole())) {
            newuser.setRole(user.getRole());
        }
        return null;
    }
    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }
}
