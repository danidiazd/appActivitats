package com.appActivitats.activities.exception;

import com.appActivitats.entity.activity.exception.ActivityNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        String activityId = "123";
        ActivityNotFoundException exception = new ActivityNotFoundException(activityId);
        assertEquals(activityId + " not found", exception.getMessage());
    }
}