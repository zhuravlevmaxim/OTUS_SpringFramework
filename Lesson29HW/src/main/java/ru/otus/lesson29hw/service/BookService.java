package ru.otus.lesson29hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson29hw.domain.Author;
import ru.otus.lesson29hw.domain.Book;
import ru.otus.lesson29hw.domain.Comment;
import ru.otus.lesson29hw.domain.Genre;
import ru.otus.lesson29hw.repository.BookRepository;
import ru.otus.lesson29hw.repository.CommentRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoOperations mongoOperations;

    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String CONTENT = "content";

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public List<Book> deleteBook(String id){
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Book editBook(Book book){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(book.getId()));
        Update update  = new Update();
        update.set(NAME, book.getName());
        update.set(DESCRIPTION, book.getDescription());
        update.set(CONTENT, book.getContent());
        mongoOperations.updateFirst(query, update, Book.class);
        return bookRepository.findById(book.getId()).get();
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Book editGenreInBook(String id, Genre genre){
        Book book = bookRepository.findById(id).get();
        book.setGenre(genre);
        book = bookRepository.save(book);
        return book;
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Book addAuthorInBook(String id, Author author){
        Book book = bookRepository.findById(id).get();
        book.setAuthor(author);
        book = bookRepository.save(book);
        return book;
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Book deleteAuthorFromBook(String id, Author author){
        Book book = bookRepository.findById(id).get();
        book.getAuthors().remove(author);
        book = bookRepository.save(book);
        return book;
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Book addCommentInBook(String id, Comment comment){
        Book book = bookRepository.findById(id).get();
        comment = commentRepository.save(comment);
        book.setComment(comment);
        book = bookRepository.save(book);
        return book;
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public Book deleteCommentFromBook(String id,Comment comment){
        Book book = bookRepository.findById(id).get();
        book.getComments().remove(comment);
        book = bookRepository.save(book);
        commentRepository.delete(comment);
        return book;
    }

    @Secured({"ROLE_ADMIN"})
    @Transactional(readOnly = false)
    public List<Book> createNewBook(Book book){
        bookRepository.save(book);
        return bookRepository.findAll();
    }
}
