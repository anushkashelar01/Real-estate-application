package com.homesphere.repository;

import com.homesphere.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    // 🔥 FILTER BY CITY + PRICE RANGE
    List<Property> findByCityContainingIgnoreCaseAndPriceBetween(
            String city,
            int minPrice,
            int maxPrice
    );
}