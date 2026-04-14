package com.homesphere.service;

import com.homesphere.model.Review;
import java.util.List;

public interface ReviewService {

    Review addReview(Review review);

    List<Review> getReviewsByProperty(Long propertyId);

    void deleteReview(Long id);
}