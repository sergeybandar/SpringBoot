package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String userName;
    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String firstName;
    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String lastName;
    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String email;
    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String password;
    @Pattern(regexp = "[0-9]{12}")
    private String phone;
    private int userStatus;
    private UserRole userRole=UserRole.USER;

}
