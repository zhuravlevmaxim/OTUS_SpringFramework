package ru.otus.lesson27hw.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson27hw.domain.Genre;
import ru.otus.lesson27hw.repository.GenreRepository;

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

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public List<Genre> deleteGenre(String id){
        genreRepository.deleteById(id);
        return genreRepository.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Genre editGenre(Genre genre){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(genre.getId()));
        Update update  = new Update();
        update.set(GENRE, genre.getGenre());
        mongoOperations.updateFirst(query, update, Genre.class);
        return genreRepository.findById(genre.getId()).get();
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public List<Genre> createNewGenre(Genre genre){
        genreRepository.save(genre);
        return genreRepository.findAll();
    }
}