package com.appActivitats.user.dto;

import com.appActivitats.entity.activity.domain.Activity;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private com.appActivitats.entity.user.dto.UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new com.appActivitats.entity.user.dto.UserMapper();
    }

@Test
void testToDTO() {
    User user = new User();
    user.setId("1");
    user.setFirstName("Dani");
    user.setLastName("Diaz");
    user.setEmail("dani@test.com");

    Activity activity1 = new Activity();
    activity1.setNameActivity("Activity1");
    Activity activity2 = new Activity();
    activity2.setNameActivity("Activity2");

    Set<Activity> activities = new HashSet<>();
    activities.add(activity1);
    activities.add(activity2);
    user.setActivities(activities);

    UserDTO userDTO = userMapper.toDTO(user);

    assertNotNull(userDTO);
    assertEquals("1", userDTO.getId());
    assertEquals("Dani", userDTO.getFirstName());
    assertEquals("Diaz", userDTO.getLastName());
    assertEquals("dani@test.com", userDTO.getEmail());
    assertEquals(new HashSet<>(Arrays.asList("Activity1", "Activity2")), new HashSet<>(userDTO.getActivityNames()));
}

    @Test
    void testToEntity() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setFirstName("Dani");
        userDTO.setLastName("Diaz");
        userDTO.setEmail("dani@test.com");
        userDTO.setActivityNames(Arrays.asList("Activity1", "Activity2"));

        User user = userMapper.toEntity(userDTO);

        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("Dani", user.getFirstName());
        assertEquals("Diaz", user.getLastName());
        assertEquals("dani@test.com", user.getEmail());

        Set<String> activityNames = user.getActivities().stream()
            .map(Activity::getNameActivity)
            .collect(Collectors.toSet());
        assertEquals(new HashSet<>(Arrays.asList("Activity1", "Activity2")), activityNames);
    }
}