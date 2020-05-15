package com.example.spring.springdemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("dog")
public class DogSound implements SoundAnimals {

    @Override
    public String sound() {
        return "woof";
    }
}
