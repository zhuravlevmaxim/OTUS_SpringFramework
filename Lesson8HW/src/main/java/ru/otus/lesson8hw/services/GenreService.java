package ru.otus.lesson8hw.services;

import ru.otus.lesson8hw.entity.Genre;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface GenreService {

    int count();
    Genre getById(int id);
    List<Genre> getAllGenre();
    void insert(String genreName);
    void deleteById(int id);
}
