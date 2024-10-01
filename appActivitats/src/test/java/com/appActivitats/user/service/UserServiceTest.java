package com.appActivitats.user.service;

import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User("Dani", "Diaz", "dani@test.com");
    }

    @Test
    void testRegisterUser() {
        doNothing().when(userService).registerUser(user);
        userService.registerUser(user);
        verify(userService, times(1)).registerUser(user);
    }

    @Test
    void testAddActivityToUser() {
        doNothing().when(userService).addActivityToUser("1", "Activity1");
        userService.addActivityToUser("1", "Activity1");
        verify(userService, times(1)).addActivityToUser("1", "Activity1");
    }

    @Test
    void testUpdateUser() {
        doNothing().when(userService).updateUser("1", user);
        userService.updateUser("1", user);
        verify(userService, times(1)).updateUser("1", user);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userService).deleteUser("1");
        userService.deleteUser("1");
        verify(userService, times(1)).deleteUser("1");
    }

    @Test
    void testGetUser() {
        when(userService.getUser("1")).thenReturn(user);
        User foundUser = userService.getUser("1");
        assertEquals(user, foundUser);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = List.of(user);
        when(userService.getAllUsers()).thenReturn(users);
        List<User> foundUsers = userService.getAllUsers();
        assertEquals(users, foundUsers);
    }

    @Test
    void testGetUsersByActivity() {
        Set<User> users = Set.of(user);
        when(userService.getUsersByActivity("1")).thenReturn(users);
        Set<User> foundUsers = userService.getUsersByActivity("1");
        assertEquals(users, foundUsers);
    }
}