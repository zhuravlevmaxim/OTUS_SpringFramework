package ru.otus.lesson12hw.service;

import ru.otus.lesson12hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface GenreService {

    long count();
    Genre getById(String id);
    List<Genre> getAllGenre();
    void insert(String idBook, String genreName);
    void deleteById(String id);
}
