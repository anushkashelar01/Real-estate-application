package com.homesphere.model;

import jakarta.persistence.*;

@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long propertyId;

    public Wishlist() {}

    public Wishlist(Long userId, Long propertyId) {
        this.userId = userId;
        this.propertyId = propertyId;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getPropertyId() { return propertyId; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }
}