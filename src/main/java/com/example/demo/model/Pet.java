package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private OrderStatus orderStatus;

    private PetStatus petStatus;
    private boolean complete;
}
