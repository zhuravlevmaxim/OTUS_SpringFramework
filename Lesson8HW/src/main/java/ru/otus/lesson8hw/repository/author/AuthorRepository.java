package ru.otus.lesson8hw.repository.author;

import ru.otus.lesson8hw.entity.Author;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface AuthorRepository {

    public long count();
    public Author getById(long id);
    public List<Author> getAll();
    public void deleteById(long id);
    public void insert(Author author);

}
