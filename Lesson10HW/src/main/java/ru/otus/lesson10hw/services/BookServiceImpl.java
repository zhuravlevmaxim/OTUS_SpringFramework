package ru.otus.lesson10hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson10hw.entity.Author;
import ru.otus.lesson10hw.entity.Book;
import ru.otus.lesson10hw.entity.Comment;
import ru.otus.lesson10hw.entity.Genre;
import ru.otus.lesson10hw.repository.book.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public Book getById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
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
        bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
}
