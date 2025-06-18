package com.example.transportplatform.controller;


import com.example.transportplatform.dto.ParcelDTO;
import com.example.transportplatform.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcels")
@RequiredArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;

    @PostMapping
    public ParcelDTO createParcel(@RequestBody ParcelDTO parcelDTO) {
        return parcelService.createParcel(parcelDTO);
    }

    @GetMapping
    public List<ParcelDTO> getAllParcels() {
        return parcelService.getAllParcels();
    }

    @GetMapping("/{id}")
    public ParcelDTO getParcelById(@PathVariable Long id) {
        return parcelService.getParcelById(id);
    }

    @PutMapping("/{id}")
    public ParcelDTO updateParcel(@PathVariable Long id, @RequestBody ParcelDTO parcelDTO) {
        return parcelService.updateParcel(id, parcelDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteParcel(@PathVariable Long id) {
        parcelService.deleteParcel(id);
    }
}

