package com.appActivitats.user.controller;

import com.appActivitats.entity.user.controller.UserController;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.dto.UserDTO;
import com.appActivitats.entity.user.dto.UserMapper;
import com.appActivitats.entity.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testRegisterUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);

        mockMvc.perform(post("/appActivitats/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"Dani\",\"lastName\":\"Diaz\",\"email\":\"dani@test.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Dani"));
    }

    @Test
    void testUpdateUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);

        mockMvc.perform(put("/appActivitats/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"Dani\",\"lastName\":\"Diaz\",\"email\":\"dani@test.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Dani"));
    }

    @Test
    void testGetUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Dani");
        User user = new User();
        when(userService.getUser(any(String.class))).thenReturn(user);
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        mockMvc.perform(get("/appActivitats/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Dani"));
    }

    @Test
    void testGetAllUsers() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Dani");
        User user = new User();
        when(userService.getAllUsers()).thenReturn(Collections.singletonList(user));
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        mockMvc.perform(get("/appActivitats/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Dani"));
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/appActivitats/users/1"))
                .andExpect(status().isNoContent());
    }
}