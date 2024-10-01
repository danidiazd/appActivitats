package com.appActivitats.entity.activities.controller;

import com.appActivitats.entity.activities.domain.Activity;
import com.appActivitats.entity.activities.dto.ActivityDTO;
import com.appActivitats.entity.activities.dto.ActivityMapper;
import com.appActivitats.entity.activities.service.ActivityService;
import com.appActivitats.entity.user.dto.UserDTO;
import com.appActivitats.entity.user.dto.UserMapper;
import com.appActivitats.entity.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appActivitats")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Register a new activity")
    @PostMapping("/activities")
    public ResponseEntity<ActivityDTO> registerActivity(@RequestBody ActivityDTO activityDTO) {
        Activity activity = activityMapper.toEntity(activityDTO);
        activityService.registerActivity(activity);
        return ResponseEntity.ok(activityMapper.toDTO(activity));
    }

    @Operation(summary = "Register a list of activities")
    @PostMapping("/addActivities")
    public ResponseEntity<List<ActivityDTO>> registerActivities(@RequestBody String json) {
        activityService.addActivitiesFromJson(json);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update an activity")
    @PutMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable String id, @RequestBody ActivityDTO activityDTO) {
        Activity activity = activityMapper.toEntity(activityDTO);
        activityDTO.setId(id);
        activityService.updateActivity(id, activity);
        return ResponseEntity.ok(activityMapper.toDTO(activity));
    }


    @Operation(summary = "Get an activity by id")
    @GetMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable String id) {
        Activity activity = activityService.getActivity(id);
        return ResponseEntity.ok(activityMapper.toDTO(activity));
    }


    @Operation(summary = "Get all activities")
    @GetMapping("/activities")
    public ResponseEntity<List<ActivityDTO>> getAllActivities() {
        List<ActivityDTO> activities = activityService.getAllActivities().stream()
                .map(activityMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(activities);
    }


    @Operation(summary = "Delete an activity")
    @DeleteMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> deleteActivity(@PathVariable String id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "Get all users by activity")
    @GetMapping("/activities/{id}/users")
    public ResponseEntity<List<UserDTO>> getUsersByActivity(@PathVariable String id) {
        List<UserDTO> users = userService.getUsersByActivity(id).stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }


    @Operation(summary = "Add a user to an activity")
    @PostMapping("/activities/{id}/users/{idUser}")
    public ResponseEntity<ActivityDTO> addUserToActivity(@PathVariable String id, @PathVariable String idUser) {
        activityService.addUsersToActivity(id, idUser);
        return ResponseEntity.ok().build();
    }
}