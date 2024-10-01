package com.appActivitats.entity.user.dto;

import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.activity.domain.Activity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Getter
@Setter
@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());

        userDTO.setActivityNames(user.getActivities().stream()
            .filter(activity -> activity != null)
            .map(Activity::getNameActivity)
            .collect(Collectors.toList()));

        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        user.setActivities(userDTO.getActivityNames().stream()
            .map(activityName -> {
                Activity activity = new Activity();
                activity.setNameActivity(activityName);
                return activity;
            })
            .collect(Collectors.toSet()));

        return user;
    }
}