package ru.otus.lesson8hw.repository.book;

import org.springframework.stereotype.Repository;
import ru.otus.lesson8hw.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
@Repository
@Transactional
public class BookRepositoryJdbc implements BookRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return (Long)entityManager.createQuery("select count(b) from Book b").getSingleResult();
    }

    @Override
    public Book getById(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Book.class,  id));
    }

    @Override
    public void insert(Book book) {
        entityManager.persist(book);
    }
}
