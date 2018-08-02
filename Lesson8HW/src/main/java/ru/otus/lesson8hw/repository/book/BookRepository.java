package ru.otus.lesson8hw.repository.book;

import ru.otus.lesson8hw.entity.Book;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface BookRepository {
    public long count();
    public Book getById(long id);
    public List<Book> getAll();
    public void deleteById(long id);
    public void insert(Book book);
}
