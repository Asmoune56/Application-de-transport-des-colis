package com.example.transportplatform.mapper;


import com.example.transportplatform.dto.ParcelDTO;
import com.example.transportplatform.model.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParcelMapper {
    ParcelDTO toDTO(Parcel parcel);
    Parcel toEntity(ParcelDTO dto);
}

