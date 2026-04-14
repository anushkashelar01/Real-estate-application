package com.homesphere.service;

import com.homesphere.model.Property;
import com.homesphere.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    // ✅ Constructor Injection (BEST PRACTICE)
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // ✅ ADD PROPERTY
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    // ✅ GET ALL PROPERTIES
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // ✅ GET PROPERTY BY ID
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    // ✅ DELETE PROPERTY
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    // 🔥 SEARCH FILTER (IMPORTANT)
    public List<Property> search(String city, int minPrice, int maxPrice) {
        return propertyRepository
                .findByCityContainingIgnoreCaseAndPriceBetween(
                        city,
                        minPrice,
                        maxPrice
                );
    }
}