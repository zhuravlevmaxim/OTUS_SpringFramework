package ru.otus.lesson12hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson12hw.domain.Author;
import ru.otus.lesson12hw.repository.AuthorRepository;

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
    public Author getById(String id) {
        return authorRepository.findById(id).get();
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
    public void deleteById(String id) {
        authorRepository.deleteById(id);
    }
}
