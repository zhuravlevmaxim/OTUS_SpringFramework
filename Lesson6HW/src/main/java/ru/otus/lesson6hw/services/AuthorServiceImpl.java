package ru.otus.lesson6hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson6hw.dao.author.AuthorJDBCOperations;
import ru.otus.lesson6hw.domain.Author;

import java.util.List;

/**
 * Created by zhmv on 19.07.2018.
 */
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorJDBCOperations authorJDBCOperations;

    @Override
    public int count() {
        return authorJDBCOperations.count();
    }

    @Override
    public Author getById(int id) {
        return authorJDBCOperations.getById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorJDBCOperations.getAllAuthor();
    }

    @Override
    public void insert(int id, String firstName, String secondName) {
        authorJDBCOperations.insert(new Author(id, firstName, secondName));
    }

    @Override
    public void deleteById(int id) {
        authorJDBCOperations.deleteById(id);
    }
}
