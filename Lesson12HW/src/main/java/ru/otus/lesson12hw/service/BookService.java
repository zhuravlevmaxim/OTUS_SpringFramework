package ru.otus.lesson12hw.service;

import ru.otus.lesson12hw.domain.Book;

import java.util.List;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface BookService {
    long count();
    Book getById(String id);
    List<Book> getAllBook();
    void insert(String name, String description, String content,
                String firstName, String secondName,
                String genreName, String comment);
    void deleteById(String id);
}
