package ru.otus.lesson10hw.services;

import ru.otus.lesson10hw.entity.Author;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface AuthorService {
    long count();
    Author getById(long id);
    List<Author> getAllAuthor();
    void insert(String firstName, String secondName);
    void deleteById(long id);
}
