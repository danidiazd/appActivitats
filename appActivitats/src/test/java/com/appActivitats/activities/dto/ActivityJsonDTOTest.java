package com.appActivitats.activities.dto;

import com.appActivitats.entity.activity.dto.ActivityJsonDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityJsonDTOTest {

    private ActivityJsonDTO activityJsonDTO;

    @BeforeEach
    void setUp() {
        activityJsonDTO = new ActivityJsonDTO("Java clase", "Una clase de Java", 20);
    }

    @Test
    void testGetNameActivity() {
        assertEquals("Java clase", activityJsonDTO.getNameActivity());
    }

    @Test
    void testSetNameActivity() {
        activityJsonDTO.setNameActivity("Java clase");
        assertEquals("Java clase", activityJsonDTO.getNameActivity());
    }

    @Test
    void testGetDescription() {
        assertEquals("Una clase de Java", activityJsonDTO.getDescription());
    }

    @Test
    void testSetDescription() {
        activityJsonDTO.setDescription("Una clase de Java");
        assertEquals("Una clase de Java", activityJsonDTO.getDescription());
    }

    @Test
    void testGetMaxCapacity() {
        assertEquals(20, activityJsonDTO.getMaxCapacity());
    }

    @Test
    void testSetMaxCapacity() {
        activityJsonDTO.setMaxCapacity(30);
        assertEquals(30, activityJsonDTO.getMaxCapacity());
    }
}