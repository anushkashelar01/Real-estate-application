package com.homesphere.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long propertyId;

    private LocalDateTime dateTime;

    private String type; // VIRTUAL / PHYSICAL

    private String status; // PENDING / APPROVED / REJECTED

    // ✅ Constructor
    public Tour() {}

    public Tour(Long userId, Long propertyId, LocalDateTime dateTime, String type, String status) {
        this.userId = userId;
        this.propertyId = propertyId;
        this.dateTime = dateTime;
        this.type = type;
        this.status = status;
    }

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}