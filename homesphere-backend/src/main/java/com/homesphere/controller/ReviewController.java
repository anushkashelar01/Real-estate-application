package com.homesphere.controller;

import com.homesphere.model.Review;
import com.homesphere.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // ================= ✅ ADD REVIEW =================
    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    // ================= ✅ GET REVIEWS BY PROPERTY =================
    @GetMapping("/{propertyId}")
    public List<Review> getReviews(@PathVariable Long propertyId) {
        return reviewService.getReviewsByProperty(propertyId);
    }

    // ================= 👑 ADMIN: GET ALL REVIEWS =================
    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // ================= ❌ DELETE REVIEW =================
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully";
    }
}