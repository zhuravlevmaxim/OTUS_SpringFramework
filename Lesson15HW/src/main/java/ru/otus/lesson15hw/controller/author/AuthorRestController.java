package ru.otus.lesson15hw.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    private final static String ID = "id";
    private final static String FIRST_NAME = "firstName";
    private final static String SECOND_NAME = "secondName";

    @PostMapping("/addAuthor")
    public List<Author> addAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }

    @DeleteMapping("/deleteAuthor/{authorId}")
    public List<Author> deleteAuthor(@PathVariable String authorId){
        authorRepository.deleteById(authorId);
        return authorRepository.findAll();
    }

    @PutMapping("/editAuthor")
    public Author editAuthor(@RequestBody Author author){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(author.getId()));
        Update update  = new Update();
        update.set(FIRST_NAME, author.getFirstName());
        update.set(SECOND_NAME, author.getSecondName());
        mongoOperations.updateFirst(query, update, Author.class);
        return authorRepository.findById(author.getId()).get();
    }
}
