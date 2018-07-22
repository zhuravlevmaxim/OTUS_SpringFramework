package ru.otus.lesson6hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson6hw.dao.genre.GenreDaoJDBC;
import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDaoJDBC genreDaoJDBC;

    @Override
    public int count() {
        return genreDaoJDBC.count();
    }

    @Override
    public Genre getById(int id) {
        return genreDaoJDBC.getById(id);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreDaoJDBC.getAllGenre();
    }

    @Override
    public void insert(int id, String genreName) {
        genreDaoJDBC.insert(new Genre(id, genreName));
    }

    @Override
    public void deleteById(int id) {
        genreDaoJDBC.deleteById(id);
    }
}
