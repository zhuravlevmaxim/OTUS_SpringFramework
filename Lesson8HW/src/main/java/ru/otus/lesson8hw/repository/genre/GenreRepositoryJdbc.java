package ru.otus.lesson8hw.repository.genre;

import org.springframework.stereotype.Repository;
import ru.otus.lesson8hw.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
@Repository
public class GenreRepositoryJdbc implements GenreRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Genre getById(long id) {
        return null;
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void insert(Genre genre) {

    }
}
