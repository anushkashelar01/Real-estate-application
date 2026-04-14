package com.homesphere.controller;

import com.homesphere.model.Property;
import com.homesphere.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {

    private final PropertyService propertyService;

    // ✅ Constructor Injection (clean)
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // ✅ Add Property
    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    // ✅ Get All Properties
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    // ✅ Get Property By ID
    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    // ✅ Delete Property
    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "Property deleted successfully";
    }

    // 🔥🔥 FILTER API (MOST IMPORTANT)
    @GetMapping("/search")
    public List<Property> searchProperties(
            @RequestParam(defaultValue = "") String city,
            @RequestParam(defaultValue = "0") int minPrice,
            @RequestParam(defaultValue = "1000000") int maxPrice
    ) {
        return propertyService.search(city, minPrice, maxPrice);
    }
}