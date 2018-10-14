package ru.otus.lesson15hw.controller.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.List;

@RestController
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MongoOperations mongoOperations;

    private static final String ID = "id";
    private static final String GENRE = "genre";

    @PostMapping("/addGenre")
    public List<Genre> addGenre(@RequestBody Genre genre){
        genreRepository.save(genre);
        return genreRepository.findAll();
    }

    @DeleteMapping("/deleteGenre/{genreId}")
    public List<Genre> deleteGenre(@PathVariable String genreId){
        genreRepository.deleteById(genreId);
        return genreRepository.findAll();
    }

    @PutMapping("/editGenre")
    public Genre editGenre(@RequestBody Genre genre){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(genre.getId()));
        Update update  = new Update();
        update.set(GENRE, genre.getGenre());
        mongoOperations.updateFirst(query, update, Genre.class);
        return genreRepository.findById(genre.getId()).get();
    }
}
