package com.homesphere.service;

import com.homesphere.model.User;
import com.homesphere.model.Property;

import java.util.List;

public interface AdminService {

    // 👤 GET ALL USERS
    List<User> getAllUsers();

    // 🏠 GET ALL PROPERTIES
    List<Property> getAllProperties();

    // ❌ DELETE USER
    void deleteUser(Long id);

    // ❌ DELETE PROPERTY
    void deleteProperty(Long id);

    // ⭐ MAKE ADMIN (NEW)
    void makeAdmin(Long id);
}
