package com.homesphere.service;

import com.homesphere.model.Wishlist;
import com.homesphere.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository repo;

    public WishlistService(WishlistRepository repo) {
        this.repo = repo;
    }

    // ADD
    public Wishlist add(Long userId, Long propertyId) {
        if (!repo.existsByUserIdAndPropertyId(userId, propertyId)) {
            return repo.save(new Wishlist(userId, propertyId));
        }
        return null;
    }

    // DELETE (🔥 FIX HERE)
    @Transactional
    public void remove(Long userId, Long propertyId) {
        repo.deleteByUserIdAndPropertyId(userId, propertyId);
    }

    // GET
    public List<Wishlist> getUserWishlist(Long userId) {
        return repo.findByUserId(userId);
    }
}