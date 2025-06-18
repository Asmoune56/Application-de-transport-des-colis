package com.example.transportplatform.controller;


import com.example.transportplatform.dto.TripDTO;
import com.example.transportplatform.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping
    public TripDTO createTrip(@RequestBody TripDTO tripDTO) {
        return tripService.createTrip(tripDTO);
    }

    @GetMapping
    public List<TripDTO> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public TripDTO getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/{id}")
    public TripDTO updateTrip(@PathVariable Long id, @RequestBody TripDTO tripDTO) {
        return tripService.updateTrip(id, tripDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
    }
}
