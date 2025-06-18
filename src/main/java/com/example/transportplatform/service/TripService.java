package com.example.transportplatform.service;

import com.example.transportplatform.dto.TripDTO;
import com.example.transportplatform.mapper.TripMapper;
import com.example.transportplatform.model.Trip;
import com.example.transportplatform.repository.TripRepository;
import com.example.transportplatform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;
    private final UserRepository userRepository;


    public TripDTO createTrip(TripDTO dto) {
        Trip trip = tripMapper.toEntity(dto);

        trip.setDriver(
                userRepository.findById(dto.getDriverId())
                        .orElseThrow(() -> new RuntimeException("Driver not found"))
        );

        return tripMapper.toDTO(tripRepository.save(trip));
    }


    public List<TripDTO> getAllTrips() {
        return tripRepository.findAll().stream()
                .map(tripMapper::toDTO)
                .toList();
    }

    public TripDTO getTripById(Long id) {
        return tripRepository.findById(id)
                .map(tripMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public TripDTO updateTrip(Long id, TripDTO dto) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        trip.setDeparture(dto.getDeparture());
        trip.setDestination(dto.getDestination());
        trip.setStops(dto.getStops());
        trip.setCargoType(dto.getCargoType());
        trip.setMaxDimensions(dto.getMaxDimensions());
        trip.setAvailableCapacity(dto.getAvailableCapacity());

        return tripMapper.toDTO(tripRepository.save(trip));
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}

