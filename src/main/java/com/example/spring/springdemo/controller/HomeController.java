package com.example.spring.springdemo.controller;

import com.example.spring.springdemo.model.Book;
import com.example.spring.springdemo.repo.BookRepository;
import com.example.spring.springdemo.service.SoundAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
private BookRepository bookRepository;
private SoundAnimals soundAnimals;

@Autowired
public HomeController(BookRepository bookRepository, SoundAnimals soundAnimals) {
        this.bookRepository = bookRepository;
        this.soundAnimals = soundAnimals;
    }

@GetMapping
    public String getIndex(Model model){
       model.addAttribute("books",bookRepository.findAll());
       model.addAttribute("newbook",new Book());
        return "index";
    }
   @PostMapping
    public String createBook(Book book){
    bookRepository.save(book);
    return "redirect:/";
    }
}
