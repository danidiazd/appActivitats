package com.appActivitats.entity.activity.exception;

public class NoFreePlacesException extends RuntimeException {
    public NoFreePlacesException(String activityId) {
        super("No free places in activity " + activityId);
    }
}
