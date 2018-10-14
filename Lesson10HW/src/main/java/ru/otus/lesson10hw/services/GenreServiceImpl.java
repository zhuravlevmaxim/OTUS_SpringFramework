package ru.otus.lesson10hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson10hw.entity.Book;
import ru.otus.lesson10hw.entity.Genre;
import ru.otus.lesson10hw.repository.book.BookRepository;
import ru.otus.lesson10hw.repository.genre.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public long count() {
        return genreRepository.count();
    }

    @Override
    public Genre getById(long id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public void insert(long idBook, String genreName) {
        Book book = bookRepository.findById(idBook);
        Genre genre = new Genre();
        genre.setGenre(genreName);
        genre.setBook(book);
        book.setGenre(genre);
        genreRepository.save(genre);
    }

    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }
}
