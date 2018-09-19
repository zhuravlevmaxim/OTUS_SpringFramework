package ru.otus.lesson17hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.lesson17hw.domain.Genre;

public interface GenreReactiveRepository extends ReactiveMongoRepository<Genre, String> {
}
