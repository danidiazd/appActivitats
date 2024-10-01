package com.appActivitats.activities.service;

import com.appActivitats.entity.activities.domain.Activity;
import com.appActivitats.entity.activities.exception.ActivityNotFoundException;
import com.appActivitats.entity.activities.service.ActivityServiceImp;
import com.appActivitats.entity.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActivityServiceTest {

    @Mock
    private ActivityServiceImp activityService;

    private Activity activity;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId("user1");
        user.setFirstName("Dani");
        user.setLastName("Diaz");
        user.setEmail("dani@test.com");

        activity = new Activity();
        activity.setId("1");
        activity.setNameActivity("Java clase");
        activity.setDescription("Una clase de Java");
        activity.setMaxCapacity(20);
        activity.setFreePlaces(20);
        activity.setUsers(Set.of(user));
    }

    @Test
    void testRegisterActivity() {
        doNothing().when(activityService).registerActivity(activity);
        activityService.registerActivity(activity);
        verify(activityService, times(1)).registerActivity(activity);
    }

    @Test
    void testUpdateActivity() {
        doNothing().when(activityService).updateActivity("1", activity);
        activityService.updateActivity("1", activity);
        verify(activityService, times(1)).updateActivity("1", activity);
    }

    @Test
    void testAddUsersToActivity() {
        doNothing().when(activityService).addUsersToActivity("1", "user1");
        activityService.addUsersToActivity("1", "user1");
        verify(activityService, times(1)).addUsersToActivity("1", "user1");
    }

    @Test
    void testAddUsersToActivity_ActivityNotFound() {
        doThrow(new ActivityNotFoundException("Activity")).when(activityService).addUsersToActivity("1", "user1");

        Exception exception = assertThrows(ActivityNotFoundException.class, () -> {
            activityService.addUsersToActivity("1", "user1");
        });

        assertEquals("Activity not found", exception.getMessage());
    }

    @Test
    void testAddUsersToActivity_UserNotFound() {
        doThrow(new ActivityNotFoundException("User")).when(activityService).addUsersToActivity("1", "user1");

        Exception exception = assertThrows(ActivityNotFoundException.class, () -> {
            activityService.addUsersToActivity("1", "user1");
        });

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void testDeleteActivity() {
        doNothing().when(activityService).deleteActivity("1");
        activityService.deleteActivity("1");
        verify(activityService, times(1)).deleteActivity("1");
    }

    @Test
    void testGetActivity() {
        when(activityService.getActivity("1")).thenReturn(activity);
        Activity foundActivity = activityService.getActivity("1");
        assertEquals(activity.getNameActivity(), foundActivity.getNameActivity());
    }

    @Test
    void testGetAllActivities() {
        List<Activity> activities = List.of(activity);
        when(activityService.getAllActivities()).thenReturn(activities);
        List<Activity> foundActivities = activityService.getAllActivities();
        assertFalse(foundActivities.isEmpty());
        assertEquals(activity.getNameActivity(), foundActivities.get(0).getNameActivity());
    }
}