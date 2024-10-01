package com.appActivitats.entity.activities.service;

import com.appActivitats.entity.activities.domain.Activity;
import com.appActivitats.entity.activities.dto.ActivityJsonDTO;
import com.appActivitats.entity.activities.exception.ActivityNotFoundException;
import com.appActivitats.entity.activities.repository.ActivityRepository;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImp implements ActivityService {


    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void registerActivity(Activity activity) {
        activity.setFreePlaces(activity.getMaxCapacity());
        activityRepository.save(activity);
    }

    @Override
    public void updateActivity(String id, Activity activity) {
        Optional<Activity> activityOptional = activityRepository.findById(activity.getId());
        if (activityOptional.isPresent()) {
            Activity activityToUpdate = activityOptional.get();
            activityToUpdate.setNameActivity(activity.getNameActivity());
            activityToUpdate.setDescription(activity.getDescription());
            activityToUpdate.setMaxCapacity(activity.getMaxCapacity());
            activityToUpdate.setFreePlaces(activity.getFreePlaces());
            activityRepository.save(activityToUpdate);
        } else {
            throw new ActivityNotFoundException("Activity not found");
        }
    }

    @Override
    public void addUsersToActivity(String id, String userID) {

        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isEmpty()) {
            throw new ActivityNotFoundException("Activity not found");
        }

        Optional<User> optionalUser = userRepository.findByid(userID);
        if (optionalUser.isEmpty()) {
            throw new ActivityNotFoundException("User not found");
        }

        Activity activity = optionalActivity.get();
        User user = optionalUser.get();
        activity.getUsers().add(user);
        activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(String id) {
        Optional<Activity> activityOptional = activityRepository.findById(id);
        if (activityOptional.isPresent()) {
            activityRepository.delete(activityOptional.get());
        } else {
            throw new ActivityNotFoundException("Activity not found");
        }

    }

    @Override
    public void addActivitiesFromJson(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<ActivityJsonDTO> activityJsonDTOList = null;
        try {
            activityJsonDTOList = objectMapper.readValue(json, new TypeReference<List<ActivityJsonDTO>>() {});
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
