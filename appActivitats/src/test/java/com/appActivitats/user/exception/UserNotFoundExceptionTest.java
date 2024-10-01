package com.appActivitats.user.exception;

import com.appActivitats.entity.user.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNotFoundExceptionTest {

    @Test
    void testUserNotFoundExceptionMessage() {
        String userId = "123";
        UserNotFoundException exception = new UserNotFoundException(userId);
        assertEquals("123 not found", exception.getMessage());
    }
}