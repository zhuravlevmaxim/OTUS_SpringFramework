package ru.otus.lesson10hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson10hw.entity.Book;
import ru.otus.lesson10hw.entity.Comment;
import ru.otus.lesson10hw.repository.book.BookRepository;
import ru.otus.lesson10hw.repository.comment.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public long count() {
        return commentRepository.count();
    }

    @Override
    public Comment getById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public void insert(long idBook, String commentS) {
        Book book = bookRepository.findById(idBook);
        Comment comment = new Comment();
        comment.setComment(commentS);
        comment.setBook(book);
        book.setComment(comment);
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }
}
