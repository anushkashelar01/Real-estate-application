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
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ================= REGISTER =================
    @PostMapping("/register")
    public UserDto registerUser(@RequestBody User user) {

        // 🔥 FORCE DEFAULT ROLE
        user.setRole("USER");

        return userService.registerUser(user);
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody LoginRequest request) {

        // ✅ GET USER FROM DB
        UserDto user = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        // ❌ if invalid
        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        // ✅ GENERATE TOKEN
        String token = jwtUtil.generateToken(user.getEmail());

        // ✅ RETURN FULL DATA (IMPORTANT)
        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}