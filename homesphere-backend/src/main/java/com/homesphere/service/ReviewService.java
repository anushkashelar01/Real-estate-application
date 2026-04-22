package com.homesphere.service;

import com.homesphere.model.Review;
import java.util.List;

public interface ReviewService {

    // ✅ Add Review
    Review addReview(Review review);

    // ✅ Get Reviews by Property
    List<Review> getReviewsByProperty(Long propertyId);

    // 👑 ADMIN: Get All Reviews (NEW)
    List<Review> getAllReviews();

    // ❌ Delete Review
    void deleteReview(Long id);
}