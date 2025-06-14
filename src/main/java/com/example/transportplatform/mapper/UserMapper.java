package com.example.transportplatform.mapper;

import com.example.transportplatform.dto.UserDTO;
import com.example.transportplatform.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO dto);
}
