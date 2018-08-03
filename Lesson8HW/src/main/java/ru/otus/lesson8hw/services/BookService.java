package ru.otus.lesson8hw.services;

import ru.otus.lesson8hw.entity.Book;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface BookService {
    long count();
    Book getById(long id);
    List<Book> getAllBook();
    void insert(String name, String description,
                long idAuthor, String firstName, String secondName,
                long idGenre, String genreName);
    void deleteById(long id);
}
