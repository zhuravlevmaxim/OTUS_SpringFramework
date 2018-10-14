package ru.otus.lesson12hw.service;

import ru.otus.lesson12hw.domain.Comment;

import java.util.List;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface CommentService {
    long count();
    Comment getById(String id);
    List<Comment> getAllComment();
    void insert(String idBook, String comment);
    void deleteById(String id);
}
