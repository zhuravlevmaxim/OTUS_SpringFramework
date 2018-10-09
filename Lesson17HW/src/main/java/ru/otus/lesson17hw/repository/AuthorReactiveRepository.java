package ru.otus.lesson17hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.lesson17hw.domain.Author;

public interface AuthorReactiveRepository extends ReactiveMongoRepository<Author, String> {
}
