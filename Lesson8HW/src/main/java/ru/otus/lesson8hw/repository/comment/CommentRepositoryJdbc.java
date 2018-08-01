package ru.otus.lesson8hw.repository.comment;

import org.springframework.stereotype.Repository;
import ru.otus.lesson8hw.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */

@Repository
public class CommentRepositoryJdbc implements  CommentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Comment getById(long id) {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void insert(Comment comment) {

    }
}
