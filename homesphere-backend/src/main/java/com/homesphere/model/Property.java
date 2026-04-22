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

    // 🔥 NEW FIELDS (FR10 + 360°)
    private String description;
    private String address;
    private String contactNumber;
    private String propertyType;
    private Integer bedrooms;
    private Double area;

    // 🌐 360 VIEW IMAGE
    private String panoramaImage;

    // ================= CONSTRUCTORS =================

    // ✅ Default Constructor
    public Property() {}

    // ✅ Existing Constructor (unchanged)
    public Property(String title, String city, double price, String image) {
        this.title = title;
        this.city = city;
        this.price = price;
        this.image = image;
    }

    // 🔥 FULL CONSTRUCTOR (NEW)
    public Property(String title, String city, double price, String image,
                    String description, String address, String contactNumber,
                    String propertyType, int bedrooms, double area, String panoramaImage) {

        this.title = title;
        this.city = city;
        this.price = price;
        this.image = image;
        this.description = description;
        this.address = address;
        this.contactNumber = contactNumber;
        this.propertyType = propertyType;
        this.bedrooms = bedrooms;
        this.area = area;
        this.panoramaImage = panoramaImage;
    }

    // ================= GETTERS & SETTERS =================

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

    // 🔥 NEW GETTERS & SETTERS

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getPanoramaImage() {
        return panoramaImage;
    }

    public void setPanoramaImage(String panoramaImage) {
        this.panoramaImage = panoramaImage;
    }

    // ================= DEBUG =================

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", bedrooms=" + bedrooms +
                ", area=" + area +
                ", panoramaImage='" + panoramaImage + '\'' +
                '}';
    }
}