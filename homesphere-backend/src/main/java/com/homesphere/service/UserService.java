package com.homesphere.service;

import com.homesphere.dto.UserDto;
import com.homesphere.model.User;

public interface UserService {

    // 🔐 EXISTING (keep as it is)
    UserDto registerUser(User user);
    UserDto loginUser(String email, String password);

    // 👤 USER PROFILE (ADD THIS)
    User getUserById(Long id);
    User updateUser(Long id, User user);
}