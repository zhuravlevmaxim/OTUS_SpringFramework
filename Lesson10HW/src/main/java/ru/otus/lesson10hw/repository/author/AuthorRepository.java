package ru.otus.lesson10hw.repository.author;

import org.springframework.data.repository.CrudRepository;
import ru.otus.lesson10hw.entity.Author;

import java.util.List;

/**
 * Created by zhmv on 05.08.2018.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

    public Author  findById(long id);

    public List<Author> findAll();
}
