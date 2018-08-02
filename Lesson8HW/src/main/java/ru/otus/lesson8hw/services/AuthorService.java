package ru.otus.lesson8hw.services;

import ru.otus.lesson8hw.entity.Author;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface AuthorService {
    int count();
    Author getById(int id);
    List<Author> getAllAuthor();
    void insert(String firstName, String secondName);
    void deleteById(int id);
}
