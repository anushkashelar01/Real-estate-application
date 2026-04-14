package com.homesphere.controller;

import com.homesphere.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // ✅ Total Properties
    @GetMapping("/total-properties")
    public long getTotalProperties() {
        return analyticsService.getTotalProperties();
    }

    // ✅ Wishlist Count
    @GetMapping("/wishlist-count/{userId}")
    public long getWishlistCount(@PathVariable Long userId) {
        return analyticsService.getWishlistCount(userId);
    }

    // ✅ City Stats
    @GetMapping("/city-stats")
    public Map<String, Long> getCityStats() {
        return analyticsService.getCityStats();
    }
}