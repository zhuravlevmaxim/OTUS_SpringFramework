package ru.otus.lesson19hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson19hw.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
