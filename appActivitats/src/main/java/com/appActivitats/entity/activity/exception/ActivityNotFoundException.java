package com.appActivitats.entity.activity.exception;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(String id) {
        super(id + " not found");
    }
}
