package com.homesphere.service;

import com.homesphere.model.Tour;
import com.homesphere.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour bookTour(Tour tour) {
        tour.setStatus("PENDING");
        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> getToursByProperty(Long propertyId) {
        return tourRepository.findByPropertyId(propertyId);
    }

    @Override
    public List<Tour> getToursByUser(Long userId) {
        return tourRepository.findByUserId(userId);
    }

    @Override
    public Tour updateStatus(Long id, String status) {
        Tour tour = tourRepository.findById(id).orElseThrow();
        tour.setStatus(status);
        return tourRepository.save(tour);
    }
}