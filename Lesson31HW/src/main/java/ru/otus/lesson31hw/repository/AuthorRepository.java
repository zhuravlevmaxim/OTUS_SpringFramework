package ru.otus.lesson31hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson31hw.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
