package com.appActivitats.entity.user.exception;

public class UserAlredyExistException extends RuntimeException {
    public UserAlredyExistException(String message) {
        super(message);
    }
}
