package com.homesphere.repository;

import com.homesphere.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    // ✅ Get all wishlist items of a user
    List<Wishlist> findByUserId(Long userId);

    // ✅ Check if property already in wishlist
    boolean existsByUserIdAndPropertyId(Long userId, Long propertyId);

    // ✅ Remove property from wishlist
    @Transactional
    @Modifying
    void deleteByUserIdAndPropertyId(Long userId, Long propertyId);

    // ✅ Count wishlist items (for analytics)
    long countByUserId(Long userId);
}