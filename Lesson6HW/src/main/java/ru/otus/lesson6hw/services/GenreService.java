package ru.otus.lesson6hw.services;

import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public interface GenreService {
    int count();
    Genre getById(int id);
    List<Genre> getAllGenre();
    void insert(int id, String genreName);
    void deleteById(int id);
}
