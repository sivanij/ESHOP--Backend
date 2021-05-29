package com.upgrad.capstone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class eshopProduct {
    @Id
    @GeneratedValue
    private int productId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)

    private double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private int availableItems;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;


    public eshopProduct(int productId, String name, String category, double price, String description, String manufacturer, int availableItems, String imageUrl, LocalDateTime created, LocalDateTime updated) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.availableItems = availableItems;
        this.imageUrl = imageUrl;
        this.created = created;
        this.updated = updated;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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


    @Override
    public String toString() {
        return "eshopProduct{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", availableItems=" + availableItems +
                ", imageUrl='" + imageUrl + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
