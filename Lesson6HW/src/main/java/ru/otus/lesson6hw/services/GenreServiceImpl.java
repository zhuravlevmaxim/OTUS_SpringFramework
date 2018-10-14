package ru.otus.lesson6hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson6hw.dao.genre.GenreJDBCOperations;
import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreJDBCOperations genreJDBCOperations;

    @Override
    public int count() {
        return genreJDBCOperations.count();
    }

    @Override
    public Genre getById(int id) {
        return genreJDBCOperations.getById(id);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreJDBCOperations.getAllGenre();
    }

    @Override
    public void insert(int id, String genreName) {
        genreJDBCOperations.insert(new Genre(id, genreName));
    }

    @Override
    public void deleteById(int id) {
        genreJDBCOperations.deleteById(id);
    }
}
