package ru.otus.lesson12hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.lesson12hw.domain.Book;
import ru.otus.lesson12hw.domain.Comment;
import ru.otus.lesson12hw.repository.BookRepository;
import ru.otus.lesson12hw.repository.CommentRepository;

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
    public Comment getById(String id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public void insert(String idBook, String commentS) {
        Book book = bookRepository.findById(idBook).get();
        Comment comment = new Comment();
        comment.setComment(commentS);
        book.setComment(comment);
        bookRepository.save(book);
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
