package ru.otus.lesson6hw.services;

import ru.otus.lesson6hw.domain.Book;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public interface BookService {
    int count();
    Book getById(int id);
    List<Book> getAllBook();
    void insert(int id, String name, String description,
                int idAuthor, String firstName, String secondName,
                int idGenre, String genreName);
    void deleteById(int id);
}
