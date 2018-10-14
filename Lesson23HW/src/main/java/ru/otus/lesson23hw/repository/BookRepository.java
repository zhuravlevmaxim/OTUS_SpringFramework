package ru.otus.lesson23hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.lesson23hw.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
