package com.example.transportplatform.service;

import com.example.transportplatform.dto.RequestDTO;
import com.example.transportplatform.mapper.RequestMapper;
import com.example.transportplatform.model.Parcel;
import com.example.transportplatform.model.Request;
import com.example.transportplatform.model.Trip;
import com.example.transportplatform.model.User;
import com.example.transportplatform.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

        private final RequestRepository requestRepository;
        private final RequestMapper requestMapper;
        private final UserRepository userRepository;
        private final TripRepository tripRepository;
        private final ParcelRepository parcelRepository;


    public RequestDTO createRequest(RequestDTO dto) {
        Request request = requestMapper.toEntity(dto);

        // Charger et lier le sender
        if (dto.getSenderId() != null) {
            User sender = userRepository.findById(dto.getSenderId())
                    .orElseThrow(() -> new RuntimeException("Sender not found"));
            request.setSender(sender);
        }

        // Charger et lier le trip
        if (dto.getTripId() != null) {
            Trip trip = tripRepository.findById(dto.getTripId())
                    .orElseThrow(() -> new RuntimeException("Trip not found"));
            request.setTrip(trip);
        }

        // Sauvegarder le parcel si pas cascade
        if (request.getParcel() != null) {
            parcelRepository.save(request.getParcel());
        }

        request = requestRepository.save(request);
        return requestMapper.toDTO(request);
    }




    public List<RequestDTO> getAllRequests() {
        return requestRepository.findAll().stream()
                .map(requestMapper::toDTO)
                .toList();
    }

    public RequestDTO getRequestById(Long id) {
        return requestRepository.findById(id)
                .map(requestMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    public RequestDTO updateRequest(Long id, RequestDTO dto) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(dto.getStatus());
        request.setRequestDate(dto.getRequestDate());
        return requestMapper.toDTO(requestRepository.save(request));
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}

