package com.appActivitats.user.dto;

import com.appActivitats.entity.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userDTO = new UserDTO("1", "Dani", "Diaz", "dani@test.com", Arrays.asList("Activity1", "Activity2"));
    }

    @Test
    void testUserDTOConstructor() {
        assertEquals("1", userDTO.getId());
        assertEquals("Dani", userDTO.getFirstName());
        assertEquals("Diaz", userDTO.getLastName());
        assertEquals("dani@test.com", userDTO.getEmail());
        assertEquals(Arrays.asList("Activity1", "Activity2"), userDTO.getActivityNames());
    }

    @Test
    void testSettersAndGetters() {
        userDTO.setId("2");
        assertEquals("2", userDTO.getId());

        userDTO.setFirstName("Daniel");
        assertEquals("Daniel", userDTO.getFirstName());

        userDTO.setLastName("Diaz");
        assertEquals("Diaz", userDTO.getLastName());

        userDTO.setEmail("daniel@test.com");
        assertEquals("daniel@test.com", userDTO.getEmail());

        userDTO.setActivityNames(Arrays.asList("Activity3"));
        assertEquals(Arrays.asList("Activity3"), userDTO.getActivityNames());
    }
}