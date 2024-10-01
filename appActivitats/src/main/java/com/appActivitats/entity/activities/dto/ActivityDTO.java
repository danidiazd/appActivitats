package com.appActivitats.entity.activities.dto;

import com.appActivitats.entity.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {

    private String id;
    private String nameActivity;
    private String description;
    private int maxCapacity;
    private int freePlaces;
    private Set<UserDTO> users;


}