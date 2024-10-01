package com.appActivitats.entity.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(id + " not found");
    }
}
