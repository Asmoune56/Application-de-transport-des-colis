package com.example.transportplatform.service;

import com.example.transportplatform.dto.ParcelDTO;
import com.example.transportplatform.mapper.ParcelMapper;
import com.example.transportplatform.model.Parcel;
import com.example.transportplatform.repository.ParcelRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final ParcelMapper parcelMapper;

    public ParcelDTO createParcel(ParcelDTO dto) {
        return parcelMapper.toDTO(parcelRepository.save(parcelMapper.toEntity(dto)));
    }

    public List<ParcelDTO> getAllParcels() {
        return parcelRepository.findAll().stream()
                .map(parcelMapper::toDTO)
                .toList();
    }

    public ParcelDTO getParcelById(Long id) {
        return parcelRepository.findById(id)
                .map(parcelMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parcel not found"));
    }

    public ParcelDTO updateParcel(Long id, ParcelDTO dto) {
        Parcel parcel = parcelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        parcel.setDescription(dto.getDescription());
        parcel.setWeight(dto.getWeight());
        parcel.setHeight(dto.getHeight());
        parcel.setWidth(dto.getWidth());
        parcel.setLength(dto.getLength());

        return parcelMapper.toDTO(parcelRepository.save(parcel));
    }

    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }
}

