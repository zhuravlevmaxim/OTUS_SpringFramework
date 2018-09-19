package ru.otus.lesson17hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.lesson17hw.domain.Book;

public interface BookReactiveRepository extends ReactiveMongoRepository<Book, String> {
}
