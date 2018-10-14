package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson8hw.entity.Author;
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.entity.Comment;
import ru.otus.lesson8hw.entity.Genre;
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
    public void insert(String name, String description, String firstName, String secondName, String genreName, String commentS) {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        Author author = new Author();
        author.setFirstName(firstName);
        author.setSecondName(secondName);
        Genre genre = new Genre();
        genre.setGenre(genreName);
        Comment comment = new Comment();
        comment.setComment(commentS);

        book.setAuthor(author);
        book.setGenre(genre);
        genre.setBook(book);
        book.setComment(comment);
        bookRepositoryJdbc.insert(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepositoryJdbc.deleteById(id);
    }
}
