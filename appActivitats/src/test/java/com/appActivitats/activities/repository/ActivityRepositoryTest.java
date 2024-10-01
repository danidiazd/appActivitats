package com.appActivitats.activities.repository;

import com.appActivitats.entity.activity.domain.Activity;
import com.appActivitats.entity.activity.repository.ActivityRepository;
import com.appActivitats.entity.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;

    private Activity activity;
    private User user;

    @BeforeEach
    void setUp() {
        activity = new Activity();
        activity.setId("1");
        activity.setNameActivity("Java clase");
        activity.setDescription("Una clase de Java");
        activity.setMaxCapacity(20);
        activity.setFreePlaces(20);
        activityRepository.save(activity);

        user = new User();
        user.setId("user1");
        user.setFirstName("Dani");
        user.setLastName("Diaz");
        user.setEmail("dani@test.com");

    }

    @Test
    void testFindById() {
        Optional<Activity> foundActivity = activityRepository.findById("1");
        assertTrue(foundActivity.isPresent());
        assertEquals(activity.getNameActivity(), foundActivity.get().getNameActivity());
    }

    @Test
    void testFindByNameActivity() {
        Optional<Activity> foundActivity = activityRepository.findByNameActivity("Java clase");
        assertTrue(foundActivity.isPresent());
        assertEquals(activity.getDescription(), foundActivity.get().getDescription());
    }

    @Test
    void testDeleteByNameActivity() {
        activityRepository.deleteByNameActivity("Java clase");
        Optional<Activity> foundActivity = activityRepository.findByNameActivity("Java clase");
        assertFalse(foundActivity.isPresent());
    }

    @Test
    void testFindByUsers() {

        activity.addUser(user);
        activityRepository.save(activity);

        List<Activity> activities = activityRepository.findByUsers("user1");
        assertFalse(activities.isEmpty());
        assertEquals(activity.getNameActivity(), activities.get(0).getNameActivity());
    }
}