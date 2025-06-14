package com.example.transportplatform.controller;

import com.example.transportplatform.dto.UserDTO;
import com.example.transportplatform.mapper.UserMapper;
import com.example.transportplatform.model.User;
import com.example.transportplatform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    // CREATE
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword("123456"); // à remplacer plus tard par BCrypt encoder
        user.setRole("USER");
        user.setVerified(false);
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(userMapper.toDTO(saved));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(userMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto) {
        User user = userMapper.toEntity(dto);
        User updated = userService.updateUser(id, user);
        return ResponseEntity.ok(userMapper.toDTO(updated));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
