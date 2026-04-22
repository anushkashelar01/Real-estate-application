package com.homesphere.controller;

import com.homesphere.model.Tour;
import com.homesphere.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@CrossOrigin(origins = "*")
public class TourController {

    @Autowired
    private TourService tourService;

    // ✅ Book Tour
    @PostMapping
    public Tour bookTour(@RequestBody Tour tour) {
        return tourService.bookTour(tour);
    }

    // ✅ Get by Property
    @GetMapping("/property/{propertyId}")
    public List<Tour> getByProperty(@PathVariable Long propertyId) {
        return tourService.getToursByProperty(propertyId);
    }

    // ✅ Get by User
    @GetMapping("/user/{userId}")
    public List<Tour> getByUser(@PathVariable Long userId) {
        return tourService.getToursByUser(userId);
    }

    // ✅ Update Status (Admin)
    @PutMapping("/{id}")
    public Tour updateStatus(@PathVariable Long id, @RequestParam String status) {
        return tourService.updateStatus(id, status);
    }
}