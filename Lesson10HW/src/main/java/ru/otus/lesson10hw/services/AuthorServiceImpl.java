package ru.otus.lesson10hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson10hw.entity.Author;
import ru.otus.lesson10hw.repository.author.AuthorRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public Author getById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public void insert(String firstName, String secondName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setSecondName(secondName);
        authorRepository.save(author);
    }

    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
}
