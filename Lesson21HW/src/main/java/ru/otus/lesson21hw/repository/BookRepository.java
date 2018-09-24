package ru.otus.lesson21hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson21hw.domain.Book;


public interface BookRepository extends MongoRepository<Book, String> {
}
