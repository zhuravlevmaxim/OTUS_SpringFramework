package ru.otus.lesson27hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson27hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
