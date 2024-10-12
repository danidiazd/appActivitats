package com.appActivitats.entity.activity.exception;

import com.appActivitats.entity.activity.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerActivity {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerActivity.class);

    @ExceptionHandler(ActivityNotFoundException.class)
    public ResponseEntity<MessageDTO> handleActivityNotFoundException(ActivityNotFoundException ex) {
        log.error("Activity not found exception", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(ex.getMessage()));
    }

    @ExceptionHandler(NoFreePlacesException.class)
    public ResponseEntity<MessageDTO> handleNoFreePlacesException(NoFreePlacesException ex) {
        log.error("No free places exception", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO(ex.getMessage()));
    }
}
