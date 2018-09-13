package ru.otus.lesson19hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson19hw.domain.Book;


public interface BookRepository extends MongoRepository<Book, String> {
}
