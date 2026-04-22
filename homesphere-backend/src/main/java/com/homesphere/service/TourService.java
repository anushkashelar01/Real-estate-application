package com.homesphere.service;

import com.homesphere.model.Tour;
import java.util.List;

public interface TourService {

    Tour bookTour(Tour tour);

    List<Tour> getToursByProperty(Long propertyId);

    List<Tour> getToursByUser(Long userId);

    Tour updateStatus(Long id, String status);
}