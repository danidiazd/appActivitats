package com.appActivitats.entity.user.domain;

import com.appActivitats.entity.activity.domain.Activity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotNull(message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only letters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;

    private Date registrationDate = new Date();

    private Set<String> activities = new HashSet<>();

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activities = new HashSet<>();
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity.getNameActivity());
    }

    public Set<String> getActivities() {
        return this.activities;
    }
}