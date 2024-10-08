package com.appActivitats.entity.activity.service;

import com.appActivitats.entity.activity.domain.Activity;

import java.util.List;

public interface ActivityService {

    void registerActivity(Activity activity);

    void updateActivity(String id, Activity activity);

    void addUsersToActivity(String id, String userID);

    void deleteActivity(String id);

    Activity getActivity(String id);

    List<Activity> getAllActivities();

    void addActivitiesFromJson(String json);
}
