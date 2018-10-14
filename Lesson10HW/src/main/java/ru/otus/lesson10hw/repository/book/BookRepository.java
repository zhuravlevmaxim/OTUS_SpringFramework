package ru.otus.lesson10hw.repository.book;

import org.springframework.data.repository.CrudRepository;
import ru.otus.lesson10hw.entity.Book;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    public Book  findById(long id);

    public List<Book> findAll();
}
