package com.appActivitats.entity.activities.exception;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(String id) {
        super(id + " not found");
    }
}
