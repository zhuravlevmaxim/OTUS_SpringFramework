package ru.otus.lesson10hw.services;

import ru.otus.lesson10hw.entity.Comment;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface CommentService {
    long count();
    Comment getById(long id);
    List<Comment> getAllComment();
    void insert(long idBook, String comment);
    void deleteById(long id);
}
