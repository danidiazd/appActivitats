package com.appActivitats.user.domain;

import com.appActivitats.entity.activities.domain.Activity;
import com.appActivitats.entity.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Dani", "Diaz", "dani@test.com");
    }

    @Test
    void testUserConstructor() {
        assertNotNull(user.getId());
        assertEquals("Dani", user.getFirstName());
        assertEquals("Diaz", user.getLastName());
        assertEquals("dani@test.com", user.getEmail());
        assertNotNull(user.getRegistrationDate());
        assertEquals(new HashSet<>(), user.getActivities());
    }

    @Test
    void testGetFullName() {
        assertEquals("Dani Diaz", user.getFullName());
    }

    @Test
    void testAddActivity() {
        Activity activity = new Activity();
        user.addActivity(activity);
        assertTrue(user.getActivities().contains(activity));
    }

    @Test
    void testSettersAndGetters() {
        user.setFirstName("Daniel");
        assertEquals("Daniel", user.getFirstName());

        user.setLastName("Diaz");
        assertEquals("Diaz", user.getLastName());

        user.setEmail("daniel@test.com");
        assertEquals("daniel@test.com", user.getEmail());

        Date newDate = new Date();
        user.setRegistrationDate(newDate);
        assertEquals(newDate, user.getRegistrationDate());

        HashSet<Activity> activities = new HashSet<>();
        user.setActivities(activities);
        assertEquals(activities, user.getActivities());
    }
}