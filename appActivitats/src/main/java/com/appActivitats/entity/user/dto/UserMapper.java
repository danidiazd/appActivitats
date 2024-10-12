package com.appActivitats.entity.user.dto;

import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.activity.domain.Activity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;
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
                .collect(Collectors.toSet()));
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setActivities(userDTO.getActivityNames().stream()
                .collect(Collectors.toSet()));



        return user;
    }
}