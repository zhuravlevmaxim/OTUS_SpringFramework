package ru.otus.lesson8hw.services;

import ru.otus.lesson8hw.entity.Book;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface BookService {
    int count();
    Book getById(int id);
    List<Book> getAllBook();
    void insert(String name, String description,
                int idAuthor, String firstName, String secondName,
                int idGenre, String genreName);
    void deleteById(int id);
}
