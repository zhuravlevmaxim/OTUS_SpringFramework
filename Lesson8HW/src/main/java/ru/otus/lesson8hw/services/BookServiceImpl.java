package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.repository.book.BookRepositoryJdbc;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryJdbc bookRepositoryJdbc;

    @Override
    public long count() {
        return bookRepositoryJdbc.count();
    }

    @Override
    public Book getById(long id) {
        return bookRepositoryJdbc.getById(id);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepositoryJdbc.getAll();
    }

    @Override
    public void insert(String name, String description, long idAuthor, String firstName, String secondName, long idGenre, String genreName) {
        //bookRepositoryJdbc.insert();
    }

    @Override
    public void deleteById(long id) {
        bookRepositoryJdbc.deleteById(id);
    }
}
