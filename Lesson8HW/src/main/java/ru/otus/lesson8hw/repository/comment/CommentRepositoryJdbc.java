package ru.otus.lesson8hw.repository.comment;

import org.springframework.stereotype.Repository;
import ru.otus.lesson8hw.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */

@Repository
@Transactional
public class CommentRepositoryJdbc implements  CommentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return entityManager.createNamedQuery("select count(*) from comment", Long.class).getSingleResult();
    }

    @Override
    public Comment getById(long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public List<Comment> getAll() {
        return  entityManager.createQuery("select c from comment c", Comment.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Comment.class,  id));
    }

    @Override
    public void insert(Comment comment) {
        entityManager.persist(comment);
    }
}
