package com.homesphere.controller;

import com.homesphere.model.User;
import com.homesphere.model.Property;
import com.homesphere.service.AdminService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // ================= 👤 GET ALL USERS =================
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // ================= 🏠 GET ALL PROPERTIES =================
    @GetMapping("/properties")
    public List<Property> getAllProperties() {
        return adminService.getAllProperties();
    }

    // ================= ❌ DELETE USER =================
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "User deleted successfully";
    }

    // ================= ❌ DELETE PROPERTY =================
    @DeleteMapping("/properties/{id}")
    public String deleteProperty(@PathVariable Long id) {
        adminService.deleteProperty(id);
        return "Property deleted successfully";
    }

    // ================= ⭐ MAKE ADMIN =================
    @PutMapping("/make-admin/{id}")
    public String makeAdmin(@PathVariable Long id) {
        adminService.makeAdmin(id);
        return "User promoted to ADMIN successfully";
    }
}