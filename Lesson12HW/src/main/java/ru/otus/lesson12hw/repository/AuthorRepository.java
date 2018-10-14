package ru.otus.lesson12hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson12hw.domain.Author;
import ru.otus.lesson12hw.domain.Book;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
}
