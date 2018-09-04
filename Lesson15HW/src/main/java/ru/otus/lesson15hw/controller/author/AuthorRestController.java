package ru.otus.lesson15hw.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.repository.AuthorRepository;

import java.util.List;

@RestController
public class AuthorRestController {

    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return "authors";
    }

    @DeleteMapping("/deleteAuthor/{authorId}")
    public List<Author> deleteAuthor(@PathVariable String authorId){
        authorRepository.deleteById(authorId);
        return authorRepository.findAll();
    }
}
