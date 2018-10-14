package ru.otus.lesson6hw.dao.book;

import ru.otus.lesson6hw.domain.Book;

import java.util.List;

/**
 * Created by zhmv on 16.07.2018.
 */
public interface BookDao {
    int count();
    Book getById(int id);
    List<Book> getAllBook();
    void insert(Book book);
    void deleteById(int id);
}
