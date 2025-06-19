package com.example.transportplatform.service;

import com.example.transportplatform.dto.DashboardStatsDTO;
import com.example.transportplatform.repository.UserRepository;
import com.example.transportplatform.repository.TripRepository;
import com.example.transportplatform.repository.ParcelRepository;
import com.example.transportplatform.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final ParcelRepository parcelRepository;
    private final RequestRepository requestRepository;

    public DashboardStatsDTO getDashboardStats() {
        long usersCount = userRepository.count();
        long tripsCount = tripRepository.count();
        long parcelsCount = parcelRepository.count();
        long requestsCount = requestRepository.count();

        return new DashboardStatsDTO(usersCount, tripsCount, parcelsCount, requestsCount);
    }
}
