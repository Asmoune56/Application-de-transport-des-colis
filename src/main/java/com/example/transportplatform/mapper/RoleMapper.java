package com.example.transportplatform.mapper;


import com.example.transportplatform.dto.RoleDTO;
import com.example.transportplatform.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    RoleDTO toDTO(Role role);
    Role toEntity(RoleDTO dto);
}

