package com.example.transportplatform.repository;


import com.example.transportplatform.model.Role;
import com.example.transportplatform.model.Role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}

