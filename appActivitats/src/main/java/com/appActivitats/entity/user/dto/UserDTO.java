package com.appActivitats.entity.user.dto;

import com.appActivitats.entity.activity.domain.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<String> activityNames = new HashSet<>();

}