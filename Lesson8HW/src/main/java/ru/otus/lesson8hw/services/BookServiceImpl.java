package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.repository.book.BookRepositoryJdbc;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryJdbc bookRepositoryJdbc;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }

    @Override
    public void insert(String name, String description, int idAuthor, String firstName, String secondName, int idGenre, String genreName) {

    }

    @Override
    public void deleteById(int id) {

    }
}
