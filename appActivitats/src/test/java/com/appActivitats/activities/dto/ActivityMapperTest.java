package com.appActivitats.activities.dto;

import com.appActivitats.entity.activity.domain.Activity;
import com.appActivitats.entity.activity.dto.ActivityDTO;
import com.appActivitats.entity.activity.dto.ActivityMapper;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.dto.UserDTO;
import com.appActivitats.entity.user.dto.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActivityMapperTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private ActivityMapper activityMapper;

    private Activity activity;
    private ActivityDTO activityDTO;
    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId("1");
        user.setFirstName("Dani");
        user.setLastName("Diaz");
        user.setEmail("dani@test.com");

        userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setFirstName("Dani");
        userDTO.setLastName("Diaz");
        userDTO.setEmail("dani@test.com");

        activity = new Activity();
        activity.setId("1");
        activity.setNameActivity("Java clase");
        activity.setDescription("Una clase de Java");
        activity.setMaxCapacity(20);
        activity.setFreePlaces(20);
        activity.setUsers(Set.of(user));

        activityDTO = new ActivityDTO("1", "Java clase", "Una clase de Java", 20, 20, Set.of(userDTO));
    }

    @Test
    void testToDTO() {
        when(userMapper.toDTO(user)).thenReturn(userDTO);

        ActivityDTO result = activityMapper.toDTO(activity);

        assertEquals(activityDTO.getId(), result.getId());
        assertEquals(activityDTO.getNameActivity(), result.getNameActivity());
        assertEquals(activityDTO.getDescription(), result.getDescription());
        assertEquals(activityDTO.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(activityDTO.getFreePlaces(), result.getFreePlaces());
        assertEquals(activityDTO.getUsers().size(), result.getUsers().size());
        assertTrue(result.getUsers().contains(userDTO));
    }

    @Test
    void testToEntity() {
        when(userMapper.toEntity(userDTO)).thenReturn(user);

        Activity result = activityMapper.toEntity(activityDTO);

        assertEquals(activity.getId(), result.getId());
        assertEquals(activity.getNameActivity(), result.getNameActivity());
        assertEquals(activity.getDescription(), result.getDescription());
        assertEquals(activity.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(activity.getFreePlaces(), result.getFreePlaces());
        assertEquals(activity.getUsers().size(), result.getUsers().size());
        assertTrue(result.getUsers().contains(user));
    }
}