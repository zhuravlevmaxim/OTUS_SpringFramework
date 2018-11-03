package ru.otus.lesson31hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson31hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
