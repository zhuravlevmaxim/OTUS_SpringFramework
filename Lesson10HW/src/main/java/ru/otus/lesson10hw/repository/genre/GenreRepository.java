package ru.otus.lesson10hw.repository.genre;

import org.springframework.data.repository.CrudRepository;
import ru.otus.lesson10hw.entity.Genre;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {

public Genre  findById(long id);

public List<Genre> findAll();
}
