package ru.otus.lesson6hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson6hw.dao.author.AuthorDaoJDBC;
import ru.otus.lesson6hw.domain.Author;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDaoJDBC authorDaoJDBC;

    @Override
    public int count() {
        return authorDaoJDBC.count();
    }

    @Override
    public Author getById(int id) {
        return authorDaoJDBC.getById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorDaoJDBC.getAllAuthor();
    }

    @Override
    public void insert(int id, String firstName, String secondName) {
        authorDaoJDBC.insert(new Author(id, firstName, secondName));
    }

    @Override
    public void deleteById(int id) {
        authorDaoJDBC.deleteById(id);
    }
}
