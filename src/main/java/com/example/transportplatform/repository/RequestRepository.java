package com.example.transportplatform.repository;


import com.example.transportplatform.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findBySenderId(Long senderId);
    List<Request> findByTripId(Long tripId);
}
