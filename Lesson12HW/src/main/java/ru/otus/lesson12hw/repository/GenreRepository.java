package ru.otus.lesson12hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson12hw.domain.Genre;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface GenreRepository extends MongoRepository<Genre, String> {
}
