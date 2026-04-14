package com.homesphere.service;

import com.homesphere.model.Property;
import com.homesphere.repository.PropertyRepository;
import com.homesphere.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    private final PropertyRepository propertyRepository;
    private final WishlistRepository wishlistRepository;

    public AnalyticsService(PropertyRepository propertyRepository,
                            WishlistRepository wishlistRepository) {
        this.propertyRepository = propertyRepository;
        this.wishlistRepository = wishlistRepository;
    }

    // ✅ Total Properties
    public long getTotalProperties() {
        return propertyRepository.count();
    }

    // ✅ Wishlist Count by User
    public long getWishlistCount(Long userId) {
        return wishlistRepository.countByUserId(userId);
    }

    // ✅ City-wise Property Count
    public Map<String, Long> getCityStats() {

        List<Property> properties = propertyRepository.findAll();

        Map<String, Long> cityStats = new HashMap<>();

        for (Property p : properties) {
            String city = p.getCity();
            cityStats.put(city, cityStats.getOrDefault(city, 0L) + 1);
        }

        return cityStats;
    }
}