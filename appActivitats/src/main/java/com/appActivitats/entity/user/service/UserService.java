package com.appActivitats.entity.user.service;

import com.appActivitats.entity.user.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void registerUser(User user);

    void addActivityToUser(String id, String nameActivity);

    void updateUser(String id, User user);

    void deleteUser(String id);

    User getUser(String id);

    List<User> getAllUsers();

    Set<User> getUsersByActivity(String id);
}