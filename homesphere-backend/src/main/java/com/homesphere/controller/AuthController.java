package com.homesphere.controller;

import com.homesphere.dto.LoginRequest;
import com.homesphere.dto.UserDto;
import com.homesphere.dto.AuthResponse;
import com.homesphere.model.User;
import com.homesphere.service.UserService;
import com.homesphere.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")   // ✅ FIX: Allow all frontend ports
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    @PostMapping("/register")
    public UserDto registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN (JWT)
    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody LoginRequest request) {

        // validate user
        userService.loginUser(request.getEmail(), request.getPassword());

        // generate token
        String token = jwtUtil.generateToken(request.getEmail());

        return new AuthResponse(token);
    }
}