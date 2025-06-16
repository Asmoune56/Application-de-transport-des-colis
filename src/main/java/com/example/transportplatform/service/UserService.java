package com.example.transportplatform.service;

import com.example.transportplatform.dto.UserDTO;
import com.example.transportplatform.mapper.UserMapper;
import com.example.transportplatform.model.User;
import com.example.transportplatform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.toDTO(user))
                .toList();
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> userMapper.toDTO(user))
                .orElseThrow(()->new RuntimeException("user not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO ) {
                User user = userRepository.findById(id).get();
                user.setEmail(userDTO.getEmail());
                user.setFirstName(userDTO.getFirstName());
                user.setLastName(userDTO.getLastName());
                return userMapper.toDTO(userRepository.save(user));
    }
}
