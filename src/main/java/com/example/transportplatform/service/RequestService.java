package com.example.transportplatform.service;

import com.example.transportplatform.dto.RequestDTO;
import com.example.transportplatform.mapper.RequestMapper;
import com.example.transportplatform.model.Request;
import com.example.transportplatform.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    public RequestDTO createRequest(RequestDTO dto) {
        return requestMapper.toDTO(requestRepository.save(requestMapper.toEntity(dto)));
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

