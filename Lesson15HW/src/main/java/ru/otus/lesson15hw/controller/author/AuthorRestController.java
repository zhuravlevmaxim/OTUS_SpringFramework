package ru.otus.lesson15hw.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.repository.AuthorRepository;

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

    @DeleteMapping("/deleteAuthor")
    public String deleteAuthor(@RequestBody Author author){
        //authorRepository.delete(author);
        return "authors";
    }
}
