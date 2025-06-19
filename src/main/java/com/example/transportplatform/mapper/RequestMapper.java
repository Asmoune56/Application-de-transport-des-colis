package com.example.transportplatform.mapper;

import com.example.transportplatform.dto.ParcelDTO;
import com.example.transportplatform.dto.RequestDTO;
import com.example.transportplatform.model.Request;
import com.example.transportplatform.model.Parcel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestMapper {

    @Mapping(source = "sender.id", target = "senderId")
    @Mapping(source = "trip.id", target = "tripId")
    RequestDTO toDTO(Request request);

    @Mapping(source = "senderId", target = "sender.id")
    @Mapping(source = "tripId", target = "trip.id")
    Request toEntity(RequestDTO dto);

    // Mapper pour Parcel
    ParcelDTO toParcelDTO(Parcel parcel);
    Parcel toParcelEntity(ParcelDTO dto);

}
