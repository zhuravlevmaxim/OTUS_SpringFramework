package ru.otus.lesson8hw.repository.author;

import org.springframework.stereotype.Repository;
import ru.otus.lesson8hw.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
@Repository
@Transactional
public class AuthorRepositoryJdbc implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return entityManager.createNamedQuery("select count(*) from author_table", Long.class).getSingleResult();
    }

    @Override
    public Author getById(long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return entityManager.createQuery("select a from author_table a", Author.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Author.class,  id));
    }

    @Override
    public void insert(Author author) {
        entityManager.persist(author);
    }
}
