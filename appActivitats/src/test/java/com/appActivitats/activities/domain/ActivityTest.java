package com.appActivitats.activities.domain;

import com.appActivitats.entity.activity.domain.Activity;
import com.appActivitats.entity.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    private Activity activity;
    private User user;

    @BeforeEach
    void setUp() {
        activity = new Activity();
        activity.setNameActivity("Java clase");
        activity.setDescription("Una clase de Java");
        activity.setMaxCapacity(20);
        activity.setFreePlaces(20);

        user = new User();
        user.setFirstName("Dani");
        user.setLastName("Diaz");
        user.setEmail("dani@test.com");
    }

    @Test
    void testAddUser() {
        activity.addUser(user);
        assertEquals(19, activity.getFreePlaces());
        assertTrue(activity.getUsers().contains(user));
    }

    @Test
    void testSetNameActivity() {
        activity.setNameActivity("Java clase");
        assertEquals("Java clase", activity.getNameActivity());
    }

    @Test
    void testSetDescription() {
        activity.setDescription("Una clase de Java");
        assertEquals("Una clase de Java", activity.getDescription());
    }

    @Test
    void testSetMaxCapacity() {
        activity.setMaxCapacity(30);
        assertEquals(30, activity.getMaxCapacity());
    }

    @Test
    void testSetFreePlaces() {
        activity.setFreePlaces(15);
        assertEquals(15, activity.getFreePlaces());
    }
}