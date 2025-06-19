package com.example.transportplatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_roles")
@Data

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;
}
