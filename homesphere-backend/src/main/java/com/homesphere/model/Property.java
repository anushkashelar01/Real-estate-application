package com.homesphere.model;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String city;

    private double price;

    private String image;

    // ✅ Default Constructor
    public Property() {}

    // ✅ Parameterized Constructor
    public Property(String title, String city, double price, String image) {
        this.title = title;
        this.city = city;
        this.price = price;
        this.image = image;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // ✅ Optional (DEBUGGING)
    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}