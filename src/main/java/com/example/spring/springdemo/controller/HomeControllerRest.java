package com.example.spring.springdemo.controller;

import com.example.spring.springdemo.model.Book;
import com.example.spring.springdemo.repo.BookRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"},produces = "application/json")
public class HomeControllerRest {
    private BookRepository bookRepository;

    public HomeControllerRest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>getBookById(@PathVariable("id")Long id){
        Optional<Book>bookMaybe = bookRepository.findById(id);
        if(bookMaybe.isPresent()){
            return new ResponseEntity<>(bookMaybe.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable("id")Long id){
        try{
            bookRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

    @PutMapping("{/id}")
    public Book putBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PatchMapping(path ={"/id"},consumes = "application/json")
    public Book patchBook(@PathVariable("id")Long id,@RequestBody Book bookPath){
        Book bookRefresh = bookRepository.findById(id).get();
        if(bookPath.getAuthor()!=null){
            bookRefresh.setAuthor(bookPath.getAuthor());
        }
        if(bookPath.getName()!=null){
            bookRefresh.setName(bookPath.getName());
        }
        return bookRepository.save(bookRefresh);
    }





}
