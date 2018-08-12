package ru.otus.lesson12hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson12hw.domain.Book;
import ru.otus.lesson12hw.domain.Genre;
import ru.otus.lesson12hw.repository.BookRepository;
import ru.otus.lesson12hw.repository.GenreRepository;

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
    public Genre getById(String id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public void insert(String idBook, String genreName) {
        Book book = bookRepository.findById(idBook).get();
        Genre genre = new Genre();
        genre.setGenre(genreName);
        book.setGenre(genre);
        genreRepository.save(genre);
        bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        genreRepository.deleteById(id);
    }
}
