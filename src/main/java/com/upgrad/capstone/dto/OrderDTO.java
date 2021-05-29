package com.upgrad.capstone.dto;

import java.time.LocalDateTime;

public class OrderDTO {
    private int id;
    private double amount;
    private LocalDateTime order_date;
    private int user_id;
    private int product_product_id;
    private int shipping_address_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_product_id() {
        return product_product_id;
    }

    public void setProduct_product_id(int product_product_id) {
        this.product_product_id = product_product_id;
    }

    public int getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }
}
