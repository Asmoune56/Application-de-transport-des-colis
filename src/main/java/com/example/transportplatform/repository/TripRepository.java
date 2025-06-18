package com.example.transportplatform.repository;


import com.example.transportplatform.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDepartureAndDestination(String departure, String destination);
    List<Trip> findByDriverId(Long driverId);
}

