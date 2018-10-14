package ru.otus.lesson15hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson15hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
