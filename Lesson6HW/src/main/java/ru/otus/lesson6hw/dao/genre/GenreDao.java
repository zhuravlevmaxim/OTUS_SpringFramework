package ru.otus.lesson6hw.dao.genre;

import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 16.07.2018.
 */
public interface GenreDao {
    int count();
    Genre getById(int id);
    List<Genre> getAllGenre();
    void deleteById(int id);
    void insert(Genre genre);
}
