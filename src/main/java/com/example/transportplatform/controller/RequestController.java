package com.example.transportplatform.controller;


import com.example.transportplatform.dto.RequestDTO;
import com.example.transportplatform.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public RequestDTO createRequest(@RequestBody RequestDTO requestDTO) {
        return requestService.createRequest(requestDTO);
    }

    @GetMapping
    public List<RequestDTO> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public RequestDTO getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PutMapping("/{id}")
    public RequestDTO updateRequest(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        return requestService.updateRequest(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
    }
}

