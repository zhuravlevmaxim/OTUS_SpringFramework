package ru.otus.lesson8hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.entity.Comment;
import ru.otus.lesson8hw.repository.book.BookRepositoryJdbc;
import ru.otus.lesson8hw.repository.comment.CommentRepositoryJdbc;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepositoryJdbc commentRepositoryJdbc;
    @Autowired
    private BookRepositoryJdbc bookRepositoryJdbc;

    @Override
    public long count() {
        return commentRepositoryJdbc.count();
    }

    @Override
    public Comment getById(long id) {
        return commentRepositoryJdbc.getById(id);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepositoryJdbc.getAll();
    }

    @Override
    public void insert(long idBook, String commentS) {
        Book book = bookRepositoryJdbc.getById(idBook);
        Comment comment = new Comment();
        comment.setComment(commentS);
        comment.setBook(book);
        book.setComment(comment);
        commentRepositoryJdbc.insert(comment);
    }

    @Override
    public void deleteById(long id) {
        commentRepositoryJdbc.deleteById(id);
    }
}
