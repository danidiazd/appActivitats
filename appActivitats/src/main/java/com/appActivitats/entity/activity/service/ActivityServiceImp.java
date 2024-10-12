package com.appActivitats.entity.activity.service;

import com.appActivitats.entity.activity.domain.Activity;
import com.appActivitats.entity.activity.dto.ActivityJsonDTO;
import com.appActivitats.entity.activity.exception.ActivityNotFoundException;
import com.appActivitats.entity.activity.repository.ActivityRepository;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.repository.UserRepository;
import com.appActivitats.entity.user.service.UserServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImp implements ActivityService {

    ActivityRepository activityRepository;
    UserRepository userRepository;

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    public ActivityServiceImp(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void registerActivity(Activity activity) {
        activity.setFreePlaces(activity.getMaxCapacity());
        activityRepository.save(activity);
    }

    @Override
    public void updateActivity(String id, Activity activity) {

        activityRepository.findById(id)
                .map(activityToUpdate -> {
                    activityToUpdate.setNameActivity(activity.getNameActivity());
                    activityToUpdate.setDescription(activity.getDescription());
                    activityToUpdate.setMaxCapacity(activity.getMaxCapacity());
                    activityToUpdate.setFreePlaces(activity.getFreePlaces());
                    return activityRepository.save(activityToUpdate);
                })
                .orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
    }

    @Override
    public void addUsersToActivity(String id, String userID) {

        Optional<Activity> optionalActivity = Optional.ofNullable(activityRepository.findById(id).orElseThrow(() -> new ActivityNotFoundException("Activity not found")));
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(userID).orElseThrow(() -> new ActivityNotFoundException("User not found")));
        Activity activity = optionalActivity.get();
        User user = optionalUser.get();
        activity.addUser(user);
        activityRepository.save(activity);
        user.addActivity(activity);
        userServiceImp.addActivityToUser(userID, activity.getNameActivity());

    }

    @Override
    public void deleteActivity(String id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
        activityRepository.delete(activity);

    }

    @Override
    public void addActivitiesFromJson(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<ActivityJsonDTO> activityJsonDTOList = null;
        try {
            activityJsonDTOList = objectMapper.readValue(json, new TypeReference<List<ActivityJsonDTO>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (ActivityJsonDTO activityJsonDTO : activityJsonDTOList) {
            Activity activity = new Activity();
            activity.setNameActivity(activityJsonDTO.getNameActivity());
            activity.setDescription(activityJsonDTO.getDescription());
            activity.setMaxCapacity(activityJsonDTO.getMaxCapacity());
            activity.setFreePlaces(activityJsonDTO.getMaxCapacity());
            activityRepository.save(activity);
        }
    }

    @Override
    public Activity getActivity(String id) {
        return activityRepository.findById(id).orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
}
