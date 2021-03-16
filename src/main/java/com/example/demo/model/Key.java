package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String key;
    String userName;
    UserRole userRole;
}