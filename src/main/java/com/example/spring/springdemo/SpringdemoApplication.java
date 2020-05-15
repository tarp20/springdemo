package com.example.spring.springdemo;

import com.example.spring.springdemo.service.CatSound;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import outside.Clojure;


import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"outside","com.example.spring.springdemo"})
public class SpringdemoApplication {

    public static void main(String[] args) {
         ApplicationContext ctx =  SpringApplication.run(SpringdemoApplication.class, args);
        CatSound catSound =(CatSound)ctx.getBean("catSound");
        System.out.println(catSound.sound());

        Clojure clojure = (Clojure)ctx.getBean("clojure");
        System.out.println(clojure.learnMe());
    }



    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Some Spring's beans");
            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println); };
    }


}
