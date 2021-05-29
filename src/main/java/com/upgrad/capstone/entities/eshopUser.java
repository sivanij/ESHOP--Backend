package com.upgrad.capstone.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class eshopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 20, nullable = false)
    private String userName;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String firstName;
    @Column(length = 20, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int phoneNumber;
    @Column(length = 20, nullable = false)
    private String role;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public eshopUser(int id, String userName, String password, String firstName, String lastName, String email, int phoneNumber, String role, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "eshopUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", role='" + role + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
