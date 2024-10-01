package com.appActivitats.entity.activities.exception;

public class NoFreePlacesException extends RuntimeException {
    public NoFreePlacesException(String activityId) {
        super("No free places in activity " + activityId);
    }
}
