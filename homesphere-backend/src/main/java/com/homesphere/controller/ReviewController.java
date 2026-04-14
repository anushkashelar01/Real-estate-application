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

    // ✅ Add Review
    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    // ✅ Get Reviews by Property
    @GetMapping("/{propertyId}")
    public List<Review> getReviews(@PathVariable Long propertyId) {
        return reviewService.getReviewsByProperty(propertyId);
    }

    // ✅ Delete Review (Admin)
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully";
    }
}