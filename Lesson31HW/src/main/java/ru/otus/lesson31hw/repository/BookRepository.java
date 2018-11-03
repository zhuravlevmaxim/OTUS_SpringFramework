package ru.otus.lesson31hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson31hw.domain.Book;


public interface BookRepository extends MongoRepository<Book, String> {
}
