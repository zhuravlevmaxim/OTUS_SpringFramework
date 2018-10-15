package ru.otus.lesson21hw.repository;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson21hw.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
