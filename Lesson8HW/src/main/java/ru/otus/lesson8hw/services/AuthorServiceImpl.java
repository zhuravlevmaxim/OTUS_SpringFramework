package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson8hw.entity.Author;
import ru.otus.lesson8hw.repository.author.AuthorRepositoryJdbc;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepositoryJdbc authorRepositoryJdbc;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Author getById(int id) {
        return null;
    }

    @Override
    public List<Author> getAllAuthor() {
        return null;
    }

    @Override
    public void insert(String firstName, String secondName) {

    }

    @Override
    public void deleteById(int id) {

    }
}
