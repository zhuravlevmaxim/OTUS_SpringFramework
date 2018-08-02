package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson8hw.entity.Genre;
import ru.otus.lesson8hw.repository.genre.GenreRepositoryJdbc;

import java.util.List;

public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepositoryJdbc genreRepositoryJdbc;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Genre getById(int id) {
        return null;
    }

    @Override
    public List<Genre> getAllGenre() {
        return null;
    }

    @Override
    public void insert(String genreName) {

    }

    @Override
    public void deleteById(int id) {

    }
}
