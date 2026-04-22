package com.homesphere.service;

import com.homesphere.model.User;
import com.homesphere.model.Property;
import com.homesphere.repository.UserRepository;
import com.homesphere.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;

    public AdminServiceImpl(UserRepository userRepository,
                            PropertyRepository propertyRepository) {
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
    }

    // ================= 👤 GET ALL USERS =================
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ================= 🏠 GET ALL PROPERTIES =================
    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // ================= ❌ DELETE USER =================
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // ================= ❌ DELETE PROPERTY =================
    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    // ================= ⭐ MAKE ADMIN =================
    @Override
    public void makeAdmin(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole("ADMIN");
        userRepository.save(user);
    }
}