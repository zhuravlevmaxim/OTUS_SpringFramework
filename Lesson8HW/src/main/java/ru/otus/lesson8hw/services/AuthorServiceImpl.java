package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson8hw.entity.Author;
import ru.otus.lesson8hw.repository.author.AuthorRepositoryJdbc;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepositoryJdbc authorRepositoryJdbc;

    @Override
    public long count() {
        return authorRepositoryJdbc.count();
    }

    @Override
    public Author getById(long id) {
        return authorRepositoryJdbc.getById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepositoryJdbc.getAll();
    }

    @Override
    public void insert(String firstName, String secondName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setSecondName(secondName);
        authorRepositoryJdbc.insert(author);
    }

    @Override
    public void deleteById(long id) {
        authorRepositoryJdbc.deleteById(id);
    }
}
