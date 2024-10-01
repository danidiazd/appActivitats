package com.appActivitats.activities.exception;

import com.appActivitats.entity.activities.exception.NoFreePlacesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoFreePlacesExceptionTest {

    @Test
    void testExceptionMessage() {
        String activityId = "123";
        NoFreePlacesException exception = new NoFreePlacesException(activityId);
        assertEquals("No free places in activity " + activityId, exception.getMessage());
    }
}