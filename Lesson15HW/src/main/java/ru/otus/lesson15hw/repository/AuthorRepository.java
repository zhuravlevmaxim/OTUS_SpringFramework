package ru.otus.lesson15hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson15hw.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
