package ru.otus.lesson15hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson15hw.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}
