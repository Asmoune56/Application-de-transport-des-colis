package com.example.transportplatform.mapper;


import com.example.transportplatform.dto.TripDTO;
import com.example.transportplatform.model.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TripMapper {
    TripDTO toDTO(Trip trip);
    Trip toEntity(TripDTO dto);
}

