package com.example.spring.springdemo.model.auto;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Gym {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "gyms")
    private List<Owner> owners = new ArrayList<>();

}
