package com.upgrad.capstone.services;

import com.upgrad.capstone.dao.eshopOrderDAO;
import com.upgrad.capstone.entities.eshopOrder;
import com.upgrad.capstone.exceptions.OrderDetalisNotFoundException;
import com.upgrad.capstone.exceptions.ProductDetailsNotFoundException;
import com.upgrad.capstone.exceptions.UserDetailsNotFoundException;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private eshopOrderDAO orderDao;
    @Override
    public eshopOrder acceptOrderDetails(eshopOrder order) throws ProductDetailsNotFoundException, UserDetailsNotFoundException {

        return orderDao.save(order);

    }

    @Override
    public eshopOrder getOrderDetails(int id) throws OrderDetalisNotFoundException {

        return orderDao.findById(id);
    }

    @Override
    public boolean deleteOrder(int id) throws OrderDetalisNotFoundException {
        eshopOrder order=getOrderDetails(id);
        orderDao.delete(order);
        return true;
    }

    @Override
    public List<eshopOrder> getAllOrderDetails() {
        return null;
    }

}
