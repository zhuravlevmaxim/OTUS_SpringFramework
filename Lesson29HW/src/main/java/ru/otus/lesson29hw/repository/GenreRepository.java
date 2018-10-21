package ru.otus.lesson29hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson29hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
