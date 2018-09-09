package ru.otus.lesson17hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson17hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
