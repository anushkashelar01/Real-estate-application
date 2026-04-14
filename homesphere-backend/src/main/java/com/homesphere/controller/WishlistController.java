package com.homesphere.controller;

import com.homesphere.model.Wishlist;
import com.homesphere.service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin
public class WishlistController {

    private final WishlistService service;

    public WishlistController(WishlistService service) {
        this.service = service;
    }

    // ADD
    @PostMapping
    public Wishlist add(@RequestParam Long userId, @RequestParam Long propertyId) {
        return service.add(userId, propertyId);
    }

    // REMOVE
    @DeleteMapping
    public void remove(@RequestParam Long userId, @RequestParam Long propertyId) {
        service.remove(userId, propertyId);
    }

    // GET
    @GetMapping("/{userId}")
    public List<Wishlist> get(@PathVariable Long userId) {
        return service.getUserWishlist(userId);
    }
}