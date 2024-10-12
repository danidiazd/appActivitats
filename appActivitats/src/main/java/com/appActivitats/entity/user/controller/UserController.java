package com.appActivitats.entity.user.controller;

import com.appActivitats.entity.user.dto.UserDTO;
import com.appActivitats.entity.user.dto.UserMapper;
import com.appActivitats.entity.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appActivitats")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Register a new user", description = "Register a new user.")
    @PostMapping("/user")
    @ApiResponse(responseCode = "200", description = "User registered")
    @ApiResponse(responseCode = "400", description = "User already exists")
    @ApiResponse(responseCode = "400", description = "Invalid parameters")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userMapper.toEntity(userDTO));
        return ResponseEntity.ok(userDTO);
    }

    @Operation(summary = "Update a user", description = "Update a user.")
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userMapper.toEntity(userDTO));
        return ResponseEntity.ok(userDTO);
    }

    @Operation(summary = "Get a user", description = "Get a user.")
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        UserDTO userDTO = userMapper.toDTO(userService.getUser(id));
        return ResponseEntity.ok(userDTO);
    }

    @Operation(summary = "Get all users", description = "Get all users.")
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info("Getting all users...");
        List<UserDTO> users = userService.getAllUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Delete a user", description = "Delete a user.")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}