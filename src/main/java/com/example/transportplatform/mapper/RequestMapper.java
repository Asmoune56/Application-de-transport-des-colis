package com.example.transportplatform.mapper;


import com.example.transportplatform.dto.RequestDTO;
import com.example.transportplatform.model.Request;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = ParcelMapper.class)
public interface RequestMapper {
    RequestDTO toDTO(Request request);
    Request toEntity(RequestDTO dto);
}

