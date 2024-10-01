package com.appActivitats.entity.activity.dto;

import com.appActivitats.entity.activity.domain.Activity;
import com.appActivitats.entity.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class ActivityMapper {


    @Autowired
    private UserMapper userMapper;

    public ActivityDTO toDTO(Activity activity) {
        return new ActivityDTO(
                activity.getId(),
                activity.getNameActivity(),
                activity.getDescription(),
                activity.getMaxCapacity(),
                activity.getFreePlaces(),
                activity.getUsers().stream().map(userMapper::toDTO).collect(Collectors.toSet())
        );
    }

    public Activity toEntity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setId(activityDTO.getId());
        activity.setNameActivity(activityDTO.getNameActivity());
        activity.setDescription(activityDTO.getDescription());
        activity.setMaxCapacity(activityDTO.getMaxCapacity());
        activity.setFreePlaces(activityDTO.getFreePlaces());


        if (activityDTO.getUsers() != null) {
            activity.setUsers(activityDTO.getUsers().stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toSet()));
        } else {
            activity.setUsers(new HashSet<>());
        }

        return activity;
    }
}