package ru.otus.lesson10hw.services;

import ru.otus.lesson10hw.entity.Genre;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface GenreService {

    long count();
    Genre getById(long id);
    List<Genre> getAllGenre();
    void insert(long idBook, String genreName);
    void deleteById(long id);
}
