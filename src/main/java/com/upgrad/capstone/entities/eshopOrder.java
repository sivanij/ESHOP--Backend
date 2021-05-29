package com.upgrad.capstone.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class eshopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)

    private double amount;
    @Column(nullable = false)
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "userId" ,nullable = false)
    private eshopUser userId;
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private eshopProduct productProductID;
    @ManyToOne
    @JoinColumn(name = "shippingAddressId", nullable = false)
    private eshopShippingAddress  shippingAddressId;





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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public eshopUser getUserId() {
        return userId;
    }

    public void setUserId(eshopUser userId) {
        this.userId = userId;
    }

    public eshopProduct getProductProductID() {
        return productProductID;
    }

    public void setProductProductID(eshopProduct productProductID) {
        this.productProductID = productProductID;
    }

    public eshopShippingAddress getShippingAddressId() {
        return shippingAddressId;
    }


    public eshopOrder(){

    }

    public void setShippingAddressId(eshopShippingAddress shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public eshopOrder(int id, double amount, LocalDateTime orderDate, eshopUser userId, eshopProduct productProductID, eshopShippingAddress shippingAddressId) {
        this.id = id;
        this.amount = amount;
        this.orderDate = orderDate;
        this.userId = userId;
        this.productProductID = productProductID;
        this.shippingAddressId = shippingAddressId;
    }
    @Override
    public String toString() {
        return "eshopOrder{" +
                "id=" + id +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                ", userId=" + userId +
                ", productProductID=" + productProductID +
                ", shippingAddressId=" + shippingAddressId +
                '}';
    }
}
