package com.appActivitats.entity.user.service;

import com.appActivitats.entity.activities.domain.Activity;
import com.appActivitats.entity.activities.repository.ActivityRepository;
import com.appActivitats.entity.user.domain.User;
import com.appActivitats.entity.user.exception.UserNotFoundException;
import com.appActivitats.entity.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImp implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImp.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @Override
    public void registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        userRepository.save(user);
        log.log(Level.INFO, "User created: {0}", user.getFullName());
    }

    @Override
    public void addActivityToUser(String id, String nameActivity) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        Activity activity = activityRepository.findByNameActivity(nameActivity).orElseThrow(() -> new IllegalArgumentException("Activity not Found"));

        user.getActivities().add(activity);
        userRepository.save(user);
    }

    @Override
public void updateUser(String id, User user) {
    Optional<User> userOptional = userRepository.findById(id);
    if (userOptional.isPresent()) {
        User userToUpdate = userOptional.get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setRegistrationDate(user.getRegistrationDate());
        userRepository.save(userToUpdate);
        log.log(Level.INFO, "User updated: {0}", userToUpdate.getFullName());
    } else {
        throw new UserNotFoundException(id);
    }
}

    @Override
    public void deleteUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            log.log(Level.INFO, "User deleted: {0}", userOptional.get().getFullName());
        }
    }

    @Override
    public User getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        log.log(Level.INFO, "Getting user by id: {0}", user.getId());
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users...");
        return userRepository.findAll();
    }

    @Override
    public Set<User> getUsersByActivity(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
        return activity.getUsers();
    }
}