package com.example.transportplatform.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleName name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles = new HashSet<>();

    public enum RoleName {
        USER, CONDUCTOR, SENDER, ADMIN
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public RoleName getName() { return name; }
    public void setName(RoleName name) { this.name = name; }

    public Set<UserRole> getUserRoles() { return userRoles; }
    public void setUserRoles(Set<UserRole> userRoles) { this.userRoles = userRoles; }
}
