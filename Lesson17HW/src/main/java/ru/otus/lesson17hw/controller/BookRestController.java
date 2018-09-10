package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.repository.BookRepository;
import ru.otus.lesson17hw.repository.CommentRepository;

import java.util.List;

@RestController
public class BookRestController {

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

    @PostMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @DeleteMapping("/books/{id}")
    public @ResponseBody List<Book> deleteBook(@PathVariable String id){
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

    @PutMapping("/books")
    public @ResponseBody Book editBook(@RequestBody Book book){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(book.getId()));
        Update update  = new Update();
        update.set(NAME, book.getName());
        update.set(DESCRIPTION, book.getDescription());
        update.set(CONTENT, book.getContent());
        mongoOperations.updateFirst(query, update, Book.class);
        return bookRepository.findById(book.getId()).get();
    }

    @PutMapping("/books/{id}/editGenreInBook")
    public @ResponseBody Book editGenreInBook(@PathVariable String id, @RequestBody Genre genre){
        Book book = bookRepository.findById(id).get();
        book.setGenre(genre);
        book = bookRepository.save(book);
        return book;
    }

    @PutMapping("/books/{id}/addAuthorInBook")
    public @ResponseBody Book addAuthorInBook(@PathVariable String id, @RequestBody Author author){
        Book book = bookRepository.findById(id).get();
        book.setAuthor(author);
        book = bookRepository.save(book);
        return book;
    }

    @PutMapping("/books/{id}/deleteAuthorFromBook")
    public @ResponseBody Book deleteAuthorFromBook(@PathVariable String id, @RequestBody Author author){
        Book book = bookRepository.findById(id).get();
        book.getAuthors().remove(author);
        book = bookRepository.save(book);
        return book;
    }

    @PutMapping("/books/{id}/addCommentInBook")
    public @ResponseBody Book addCommentInBook(@PathVariable String id, @RequestBody Comment comment){
        Book book = bookRepository.findById(id).get();
        comment = commentRepository.save(comment);
        book.setComment(comment);
        book = bookRepository.save(book);
        return book;
    }

    @PutMapping("/books/{id}/deleteCommentFromBook")
    public @ResponseBody Book deleteCommentFromBook(@PathVariable String id, @RequestBody Comment comment){
        Book book = bookRepository.findById(id).get();
        book.getComments().remove(comment);
        book = bookRepository.save(book);
        return book;
    }

    @PostMapping("/books/createNewBook")
    public @ResponseBody List<Book> createNewBook(@RequestBody Book book){
        bookRepository.save(book);
        return bookRepository.findAll();
    }
}