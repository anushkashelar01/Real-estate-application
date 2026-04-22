package com.homesphere.model;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long propertyId;

    // ✅ Default Constructor
    public Wishlist() {}

    // ✅ Parameterized Constructor
    public Wishlist(Long userId, Long propertyId) {
        this.userId = userId;
        this.propertyId = propertyId;
    }

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    // ✅ Debugging (Optional but useful)
    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", userId=" + userId +
                ", propertyId=" + propertyId +
                '}';
    }
}