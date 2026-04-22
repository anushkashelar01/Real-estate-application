package com.homesphere.controller;

import com.homesphere.model.Wishlist;
import com.homesphere.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;

    // ✅ ADD TO WISHLIST
    @PostMapping
    public Wishlist addWishlist(@RequestBody Wishlist wishlist) {

        // 🔥 Prevent duplicate
        boolean exists = wishlistRepository
                .existsByUserIdAndPropertyId(
                        wishlist.getUserId(),
                        wishlist.getPropertyId()
                );

        if (!exists) {
            return wishlistRepository.save(wishlist);
        }

        return wishlist; // already exists
    }

    // ✅ GET USER WISHLIST
    @GetMapping("/{userId}")
    public List<Wishlist> getWishlist(@PathVariable Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    // ✅ REMOVE FROM WISHLIST
    @DeleteMapping("/{userId}/{propertyId}")
    public String removeWishlist(
            @PathVariable Long userId,
            @PathVariable Long propertyId
    ) {
        wishlistRepository.deleteByUserIdAndPropertyId(userId, propertyId);
        return "Removed from wishlist";
    }
}