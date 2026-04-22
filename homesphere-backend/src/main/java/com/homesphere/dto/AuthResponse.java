package com.homesphere.dto;

public class AuthResponse {

    private String token;
    private Long id;
    private String email;
    private String role;

    // ✅ EMPTY CONSTRUCTOR
    public AuthResponse() {}

    // ✅ FULL CONSTRUCTOR
    public AuthResponse(String token, Long id, String email, String role) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.role = role;
    }

    // ✅ GETTERS
    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // ✅ SETTERS
    public void setToken(String token) {
        this.token = token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}