package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson8hw.entity.Genre;
import ru.otus.lesson8hw.repository.genre.GenreRepositoryJdbc;

import java.util.List;
@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepositoryJdbc genreRepositoryJdbc;

    @Override
    public long count() {
        return genreRepositoryJdbc.count();
    }

    @Override
    public Genre getById(long id) {
        return genreRepositoryJdbc.getById(id);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepositoryJdbc.getAll();
    }

    @Override
    public void insert(String genreName) {
        //genreRepositoryJdbc.insert();
    }

    @Override
    public void deleteById(long id) {
        genreRepositoryJdbc.deleteById(id);
    }
}
