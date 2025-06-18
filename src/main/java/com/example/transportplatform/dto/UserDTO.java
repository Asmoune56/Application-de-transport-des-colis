package com.example.transportplatform.dto;

import com.example.transportplatform.model.Role;
import lombok.Data;

import java.util.Set;


@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean verified;
    private Set<Role> roles;
    private Set<Long> roleIds;
}

