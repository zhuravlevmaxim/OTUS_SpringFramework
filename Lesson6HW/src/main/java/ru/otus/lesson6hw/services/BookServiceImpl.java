package ru.otus.lesson6hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson6hw.dao.book.BookDaoJDBC;
import ru.otus.lesson6hw.domain.Author;
import ru.otus.lesson6hw.domain.Book;
import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDaoJDBC bookDaoJDBC;

    @Override
    public int count() {
        return bookDaoJDBC.count();
    }

    @Override
    public Book getById(int id) {
        return bookDaoJDBC.getById(id);
    }

    @Override
    public List<Book> getAllBook() {
        return bookDaoJDBC.getAllBook();
    }

    @Override
    public void insert(int id, String name, String description, int idAuthor, String firstName, String secondName, int idGenre, String genreName) {
        bookDaoJDBC.insert(new Book(id, name, description,
                new Author(idAuthor, firstName, secondName),
                new Genre(idGenre, genreName)));
    }

    @Override
    public void deleteById(int id) {
        bookDaoJDBC.deleteById(id);
    }
}
