package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.repository.AuthorRepository;

import java.util.List;

@RestController
public class AuthorRestController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private MongoOperations mongoOperations;

    private final static String ID = "id";
    private final static String FIRST_NAME = "firstName";
    private final static String SECOND_NAME = "secondName";

    @PostMapping("/authors")
    public @ResponseBody List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @DeleteMapping("/authors/{id}")
    public @ResponseBody List<Author> deleteAuthor(@PathVariable String id){
        authorRepository.deleteById(id);
        return authorRepository.findAll();
    }

    @PutMapping("/authors")
    public @ResponseBody Author editAuthor(@RequestBody Author author){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(author.getId()));
        Update update  = new Update();
        update.set(FIRST_NAME, author.getFirstName());
        update.set(SECOND_NAME, author.getSecondName());
        mongoOperations.updateFirst(query, update, Author.class);
        return authorRepository.findById(author.getId()).get();
    }

    @PostMapping("/authors/createNewAuthor")
    public @ResponseBody List<Author> createNewAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }
}
