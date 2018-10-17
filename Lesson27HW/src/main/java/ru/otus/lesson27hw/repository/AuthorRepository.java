package ru.otus.lesson27hw.repository;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson27hw.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
