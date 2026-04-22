package com.homesphere.service;

import com.homesphere.model.Review;
import com.homesphere.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // ================= ✅ ADD REVIEW =================
    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    // ================= ✅ GET REVIEWS BY PROPERTY =================
    @Override
    public List<Review> getReviewsByProperty(Long propertyId) {
        return reviewRepository.findByPropertyId(propertyId);
    }

    // ================= 👑 ADMIN: GET ALL REVIEWS =================
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // ================= ❌ DELETE REVIEW =================
    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}