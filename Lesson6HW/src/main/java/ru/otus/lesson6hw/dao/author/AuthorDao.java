package ru.otus.lesson6hw.dao.author;

import ru.otus.lesson6hw.domain.Author;

import java.util.List;

/**
 * Created by zhmv on 16.07.2018.
 */
public interface AuthorDao {
    int count();
    Author getById(int id);
    List<Author> getAllAuthor();
    void deleteById(int id);
    void insert(Author author);
}
