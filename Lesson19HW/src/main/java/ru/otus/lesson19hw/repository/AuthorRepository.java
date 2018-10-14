package ru.otus.lesson19hw.repository;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson19hw.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
