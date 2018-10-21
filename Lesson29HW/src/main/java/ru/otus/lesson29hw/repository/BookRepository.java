package ru.otus.lesson29hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson29hw.domain.Book;


public interface BookRepository extends MongoRepository<Book, String> {
}
