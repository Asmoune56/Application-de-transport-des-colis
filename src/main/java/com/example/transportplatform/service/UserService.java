package com.example.transportplatform.service;

import com.example.transportplatform.dto.UserDTO;
import com.example.transportplatform.mapper.UserMapper;
import com.example.transportplatform.model.User;
import com.example.transportplatform.model.UserRole;
import com.example.transportplatform.repository.RoleRepository;
import com.example.transportplatform.repository.UserRepository;
import com.example.transportplatform.repository.UserRoleRepository;
import lombok.AllArgsConstructor;

import com.example.transportplatform.model.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;


    public UserDTO createUser(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        user = userRepository.save(user); // نحتاج الـ ID

        if (dto.getRoleIds() != null && !dto.getRoleIds().isEmpty()) {
            Set<UserRole> userRoles = new HashSet<>();

            for (Long roleId : dto.getRoleIds()) {
                Role role = roleRepository.findById(roleId)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleId));

                UserRole userRole = new UserRole();
                userRole.setUser(user);
                userRole.setRole(role);

                userRoles.add(userRole);
            }

            userRoleRepository.saveAll(userRoles);
        }

        return userMapper.toDTO(user);
    }




    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setVerified(dto.isVerified());
        return userMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


