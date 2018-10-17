package ru.otus.lesson27hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson27hw.domain.Book;


public interface BookRepository extends MongoRepository<Book, String> {
}
