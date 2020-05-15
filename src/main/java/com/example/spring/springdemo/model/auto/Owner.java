package com.example.spring.springdemo.model.auto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Adress adress;

@OneToMany(mappedBy = "owner")
    private List<Car> cars = new ArrayList<>();

@ManyToMany
@JoinTable(name ="gym_owner",joinColumns = @JoinColumn(name = "gym_id"),inverseJoinColumns = @JoinColumn(name = "owner_id"))
private List<Gym> gyms = new ArrayList<>();
}
