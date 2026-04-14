package com.homesphere.service;

import com.homesphere.model.User;
import com.homesphere.model.Property;

import java.util.List;

public interface AdminService {

    List<User> getAllUsers();

    List<Property> getAllProperties();

    void deleteUser(Long id);

    void deleteProperty(Long id);
}
