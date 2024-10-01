package com.appActivitats.entity.activities.domain;

import com.appActivitats.entity.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "activities")
public class Activity {

    @Id
    private String id;
    private String nameActivity;
    private String description;
    private int maxCapacity;
    private int freePlaces;

    @DBRef
    private Set<User> users = new HashSet<>();


    public void addUser(User user) {
        this.freePlaces--;
        this.users.add(user);
    }
}