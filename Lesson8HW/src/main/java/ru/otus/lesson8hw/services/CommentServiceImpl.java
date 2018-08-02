package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson8hw.entity.Comment;
import ru.otus.lesson8hw.repository.comment.CommentRepositoryJdbc;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepositoryJdbc commentRepositoryJdbc;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Comment getById(int id) {
        return null;
    }

    @Override
    public List<Comment> getAllAuthor() {
        return null;
    }

    @Override
    public void insert(String comment) {

    }

    @Override
    public void deleteById(int id) {

    }
}
