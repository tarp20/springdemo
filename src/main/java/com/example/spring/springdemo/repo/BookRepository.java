package com.example.spring.springdemo.repo;

import com.example.spring.springdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
