package ru.otus.lesson21hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson21hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
