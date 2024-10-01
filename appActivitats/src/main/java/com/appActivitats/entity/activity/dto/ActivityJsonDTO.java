package com.appActivitats.entity.activity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityJsonDTO {

    private String nameActivity;
    private String description;
    private int maxCapacity;

}
