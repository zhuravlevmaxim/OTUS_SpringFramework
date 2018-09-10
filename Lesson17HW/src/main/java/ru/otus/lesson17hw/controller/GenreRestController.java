package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.repository.GenreRepository;

import java.util.List;

@RestController
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MongoOperations mongoOperations;

    private static final String ID = "id";
    private static final String GENRE = "genre";

    @PostMapping("/genres")
    public @ResponseBody List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    @DeleteMapping("/genres/{id}")
    public @ResponseBody List<Genre> deleteGenre(@PathVariable String id){
        genreRepository.deleteById(id);
        return genreRepository.findAll();
    }
    @PutMapping("/genres")
    public @ResponseBody Genre editGenre(@RequestBody Genre genre){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(genre.getId()));
        Update update  = new Update();
        update.set(GENRE, genre.getGenre());
        mongoOperations.updateFirst(query, update, Genre.class);
        return genreRepository.findById(genre.getId()).get();
    }

    @PostMapping("/genres/createNewGenre")
    public @ResponseBody List<Genre> createNewAuthor(@RequestBody Genre genre){
        genreRepository.save(genre);
        return genreRepository.findAll();
    }
}