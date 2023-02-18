package org.ieee.iot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Data
@Document("users")
@JsonIgnoreProperties({"id", "password", "enabled"})
public class User {

    @Transient
    public static final String SEQ_NAME = "users_sequence";

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    @Indexed(unique = true)
    private String username;
    @Indexed(unique = true)
    private String email;
    // Stores the encoded password, The real password is validated by another class.
    private String password;
    @Indexed(unique = true)
    private String phoneNumber;

    @DocumentReference
    private House house;

    // Security related fields
    private boolean enabled = true;
    private String roles;

    public User(Long id, String firstName, String lastName, String address, String username, String email, String password, String phoneNumber, House house) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.house = house;
    }
}
