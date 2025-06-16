package com.example.transportplatform.controller;

import com.example.transportplatform.dto.UserDTO;
import com.example.transportplatform.mapper.UserMapper;
import com.example.transportplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    // CREATE
    @PostMapping("/register")
   public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserDTO saved = userService.createUser(userDTO);
        return ResponseEntity.ok().body(userDTO);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    // READ ONE
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);

    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto) {
      UserDTO updated = userService.updateUser(id, dto);
      return ResponseEntity.ok().body(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
