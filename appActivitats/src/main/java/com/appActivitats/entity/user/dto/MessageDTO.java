package com.appActivitats.entity.user.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {

    private String message;

    public MessageDTO(String message) {
        this.message = message;
    }
}
