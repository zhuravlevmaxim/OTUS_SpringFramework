package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.repository.AuthorRepository;

import java.util.List;

@RestController
public class AuthorRestController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/authors")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @DeleteMapping("/authors/{id}")
    public List<Author> deleteAuthor(@PathVariable String id){
        authorRepository.deleteById(id);
        return authorRepository.findAll();
    }
}
