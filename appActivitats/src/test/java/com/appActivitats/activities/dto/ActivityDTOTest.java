package com.appActivitats.activities.dto;

import com.appActivitats.entity.activities.dto.ActivityDTO;
import com.appActivitats.entity.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDTOTest {

    private ActivityDTO activityDTO;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userDTO = new UserDTO();
        activityDTO = new ActivityDTO("1", "Java clase", "Una clase de Java", 20, 20, Set.of(userDTO));
    }

    @Test
    void testGetId() {
        assertEquals("1", activityDTO.getId());
    }

    @Test
    void testSetId() {
        activityDTO.setId("2");
        assertEquals("2", activityDTO.getId());
    }

    @Test
    void testGetNameActivity() {
        assertEquals("Java clase", activityDTO.getNameActivity());
    }

    @Test
    void testSetNameActivity() {
        activityDTO.setNameActivity("Java clase");
        assertEquals("Java clase", activityDTO.getNameActivity());
    }

    @Test
    void testGetDescription() {
        assertEquals("Una clase de Java", activityDTO.getDescription());
    }

    @Test
    void testSetDescription() {
        activityDTO.setDescription("Una clase de Java");
        assertEquals("Una clase de Java", activityDTO.getDescription());
    }

    @Test
    void testGetMaxCapacity() {
        assertEquals(20, activityDTO.getMaxCapacity());
    }

    @Test
    void testSetMaxCapacity() {
        activityDTO.setMaxCapacity(30);
        assertEquals(30, activityDTO.getMaxCapacity());
    }

    @Test
    void testGetFreePlaces() {
        assertEquals(20, activityDTO.getFreePlaces());
    }

    @Test
    void testSetFreePlaces() {
        activityDTO.setFreePlaces(15);
        assertEquals(15, activityDTO.getFreePlaces());
    }

    @Test
    void testGetUsers() {
        assertTrue(activityDTO.getUsers().contains(userDTO));
    }

    @Test
    void testSetUsers() {
        UserDTO newUserDTO = new UserDTO();
        activityDTO.setUsers(Set.of(newUserDTO));
        assertTrue(activityDTO.getUsers().contains(newUserDTO));
    }
}