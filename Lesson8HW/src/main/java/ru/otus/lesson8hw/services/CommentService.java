package ru.otus.lesson8hw.services;

import ru.otus.lesson8hw.entity.Comment;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface CommentService {
    int count();
    Comment getById(int id);
    List<Comment> getAllAuthor();
    void insert(String comment);
    void deleteById(int id);
}
