package ru.otus.lesson8hw.repository.comment;

import ru.otus.lesson8hw.entity.Comment;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface CommentRepository {
    public long count();
    public Comment getById(long id);
    public List<Comment> getAll();
    public void deleteById(long id);
    public void insert(Comment comment);
}
