package ru.otus.lesson8hw.repository.genre;

import org.springframework.stereotype.Repository;
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
@Repository
@Transactional
public class GenreRepositoryJdbc implements GenreRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return (Long)entityManager.createQuery("select count(g) from Genre g").getSingleResult();
    }

    @Override
    public Genre getById(long id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public List<Genre> getAll() {
        return entityManager.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Book.class,  id));
    }

    @Override
    public void insert(Genre genre) {
        entityManager.persist(genre);
    }
}
