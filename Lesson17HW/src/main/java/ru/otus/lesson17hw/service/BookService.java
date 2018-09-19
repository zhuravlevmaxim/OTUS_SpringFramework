package ru.otus.lesson17hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.repository.BookReactiveRepository;
import ru.otus.lesson17hw.repository.CommentReactiveRepository;

@Service
public class BookService {

    @Autowired
    private BookReactiveRepository bookRepository;
    @Autowired
    private CommentReactiveRepository commentRepository;
    @Autowired
    private ReactiveMongoOperations mongoOperations;

    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String CONTENT = "content";

    public Flux<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Flux<Book> deleteBook(String id){
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

    public Mono<Book> editBook(Book book){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(book.getId()));
        Update update  = new Update();
        update.set(NAME, book.getName());
        update.set(DESCRIPTION, book.getDescription());
        update.set(CONTENT, book.getContent());
        mongoOperations.updateFirst(query, update, Book.class);
        return bookRepository.findById(book.getId());
    }

    public Mono<Book> editGenreInBook(String id, Genre genre){
        Mono<Book> bookMono = bookRepository.findById(id);
        Book book = bookMono.block();
        book.setGenre(genre);
        bookMono = bookRepository.save(book);
        return bookMono;
    }

    public Mono<Book> addAuthorInBook(String id, Author author){
        Mono<Book> bookMono = bookRepository.findById(id);
        Book book = bookMono.block();
        book.setAuthor(author);
        bookMono = bookRepository.save(book);
        return bookMono;
    }

    public Mono<Book> deleteAuthorFromBook(String id, Author author){
        Mono<Book> bookMono = bookRepository.findById(id);
        Book book = bookMono.block();
        book.getAuthors().remove(author);
        bookMono = bookRepository.save(book);
        return bookMono;
    }

    public Mono<Book> addCommentInBook(String id, Comment comment){
        Mono<Book> bookMono = bookRepository.findById(id);
        Book book = bookMono.block();
        Mono<Comment> commentMono = commentRepository.save(comment);
        book.setComment(comment);
        bookMono = bookRepository.save(book);
        return bookMono;
    }

    public Mono<Book> deleteCommentFromBook(String id,Comment comment){
        Mono<Book> bookMono = bookRepository.findById(id);
        Book book = bookMono.block();
        book.getComments().remove(comment);
        bookMono = bookRepository.save(book);
        commentRepository.delete(comment);
        return bookMono;
    }

    public Flux<Book> createNewBook(Book book){
        bookRepository.save(book);
        return bookRepository.findAll();
    }
}