package ru.otus.lesson6hw.services;

import ru.otus.lesson6hw.domain.Author;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public interface AuthorService {
    int count();
    Author getById(int id);
    List<Author> getAllAuthor();
    void insert(int id, String firstName, String secondName);
    void deleteById(int id);
}
