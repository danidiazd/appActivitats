package com.appActivitats.entity.user.exception;

import com.appActivitats.entity.activity.dto.MessageDTO;
import com.appActivitats.entity.activity.exception.ActivityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerUser {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerUser.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageDTO> handleActivityNotFoundException(ActivityNotFoundException ex) {
        log.error("User Not Found Exception", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(ex.getMessage()));
    }

    @ExceptionHandler(UserAlredyExistException.class)
    public ResponseEntity<MessageDTO> handleUserAlredyExistException(UserAlredyExistException ex) {
        log.error("User Already Exist Exception", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO(ex.getMessage()));
    }
}
