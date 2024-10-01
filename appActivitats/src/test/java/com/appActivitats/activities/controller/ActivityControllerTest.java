package com.appActivitats.activities.controller;

import com.appActivitats.entity.activities.controller.ActivityController;
import com.appActivitats.entity.activities.domain.Activity;
import com.appActivitats.entity.activities.dto.ActivityDTO;
import com.appActivitats.entity.activities.dto.ActivityMapper;
import com.appActivitats.entity.activities.service.ActivityService;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.dto.UserDTO;
import com.appActivitats.entity.user.dto.UserMapper;
import com.appActivitats.entity.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActivityControllerTest {

    @Mock
    private ActivityService activityService;

    @Mock
    private UserService userService;

    @Mock
    private ActivityMapper activityMapper;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private ActivityController activityController;

    private Activity activity;
    private ActivityDTO activityDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        activity = new Activity();
        activityDTO = new ActivityDTO();
    }

    @Test
    void testRegisterActivity() {
        when(activityMapper.toEntity(activityDTO)).thenReturn(activity);
        when(activityMapper.toDTO(activity)).thenReturn(activityDTO);

        ResponseEntity<ActivityDTO> response = activityController.registerActivity(activityDTO);

        assertNotNull(response);
        assertEquals(activityDTO, response.getBody());
        verify(activityService, times(1)).registerActivity(activity);
    }

    @Test
    void testUpdateActivity() {
        when(activityMapper.toEntity(activityDTO)).thenReturn(activity);
        when(activityMapper.toDTO(activity)).thenReturn(activityDTO);

        ResponseEntity<ActivityDTO> response = activityController.updateActivity("1", activityDTO);

        assertNotNull(response);
        assertEquals(activityDTO, response.getBody());
        verify(activityService, times(1)).updateActivity("1", activity);
    }

    @Test
    void testGetActivity() {
        when(activityService.getActivity("1")).thenReturn(activity);
        when(activityMapper.toDTO(activity)).thenReturn(activityDTO);

        ResponseEntity<ActivityDTO> response = activityController.getActivity("1");

        assertNotNull(response);
        assertEquals(activityDTO, response.getBody());
        verify(activityService, times(1)).getActivity("1");
    }

    @Test
    void testGetAllActivities() {
        List<Activity> activities = List.of(activity);
        List<ActivityDTO> activityDTOs = List.of(activityDTO);

        when(activityService.getAllActivities()).thenReturn(activities);
        when(activityMapper.toDTO(activity)).thenReturn(activityDTO);

        ResponseEntity<List<ActivityDTO>> response = activityController.getAllActivities();

        assertNotNull(response);
        assertEquals(activityDTOs, response.getBody());
        verify(activityService, times(1)).getAllActivities();
    }

    @Test
    void testDeleteActivity() {
        doNothing().when(activityService).deleteActivity("1");

        ResponseEntity<ActivityDTO> response = activityController.deleteActivity("1");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(activityService, times(1)).deleteActivity("1");
    }

@Test
void testGetUsersByActivity() {
    UserDTO userDTO = new UserDTO();
    List<UserDTO> userDTOs = List.of(userDTO);

    when(userMapper.toDTO(any())).thenReturn(userDTO);
    when(userService.getUsersByActivity("1")).thenReturn(Set.of(new User()));

    ResponseEntity<List<UserDTO>> response = activityController.getUsersByActivity("1");

    assertNotNull(response);
    assertEquals(userDTOs, response.getBody());
    verify(userService, times(1)).getUsersByActivity("1");
}

    @Test
    void testAddUserToActivity() {
        doNothing().when(activityService).addUsersToActivity("1", "1");

        ResponseEntity<ActivityDTO> response = activityController.addUserToActivity("1", "1");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(activityService, times(1)).addUsersToActivity("1", "1");
    }
}