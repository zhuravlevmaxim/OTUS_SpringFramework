package ru.otus.lesson12hw.service;

import ru.otus.lesson12hw.domain.Author;

import java.util.List;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface AuthorService {
    long count();
    Author getById(String id);
    List<Author> getAllAuthor();
    void insert(String firstName, String secondName);
    void deleteById(String id);
}
