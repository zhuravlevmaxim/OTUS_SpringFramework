package ru.otus.lesson21hw.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson21hw.domain.Genre;
import ru.otus.lesson21hw.repository.GenreRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MongoOperations mongoOperations;

    private static final String ID = "id";
    private static final String GENRE = "genre";

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    @Transactional(readOnly = false)
    public List<Genre> deleteGenre(String id){
        genreRepository.deleteById(id);
        return genreRepository.findAll();
    }

    @Transactional(readOnly = false)
    public Genre editGenre(Genre genre){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(genre.getId()));
        Update update  = new Update();
        update.set(GENRE, genre.getGenre());
        mongoOperations.updateFirst(query, update, Genre.class);
        return genreRepository.findById(genre.getId()).get();
    }

    @Transactional(readOnly = false)
    public List<Genre> createNewGenre(Genre genre){
        genreRepository.save(genre);
        return genreRepository.findAll();
    }
}