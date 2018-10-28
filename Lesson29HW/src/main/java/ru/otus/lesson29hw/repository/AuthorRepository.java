package ru.otus.lesson29hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson29hw.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
