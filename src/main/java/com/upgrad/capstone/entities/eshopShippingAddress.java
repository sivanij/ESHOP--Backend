package com.upgrad.capstone.entities;

import javax.persistence.*;

@Entity
public class eshopShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int phone;
    @Column(nullable = false)
    private  String street;
    @Column(nullable = false)
    private  String landmark;
    @Column(nullable = false)
    private  String city;
    @Column(nullable = false)
    private  String state;
    @Column(nullable = false)
    private  String zipcode;
    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private eshopUser user;

    public eshopShippingAddress(int id, String name, int phone, String street, String landmark, String city, String state, String zipcode, eshopUser user) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public eshopUser getUserId() {
        return user;
    }

    public void setUserId(eshopUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "eshopShippingAddress{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", street='" + street + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", user=" + user +
                '}';
    }
}
