package com.homesphere.repository;

import com.homesphere.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findByPropertyId(Long propertyId);

    List<Tour> findByUserId(Long userId);
}