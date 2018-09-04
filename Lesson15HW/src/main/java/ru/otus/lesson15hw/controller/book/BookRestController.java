package ru.otus.lesson15hw.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.domain.Book;
import ru.otus.lesson15hw.domain.Comment;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.AuthorRepository;
import ru.otus.lesson15hw.repository.BookRepository;
import ru.otus.lesson15hw.repository.CommentRepository;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CommentRepository commentRepository;

    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String CONTENT = "content";
    private static final String GENRE = "genre";
    private static final String AUTHORS = "authors";

    @PostMapping("/editBook")
    public Book updateBookValue(@RequestBody Book book){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(book.getId()));
        Update update  = new Update();
        update.set(NAME, book.getName());
        update.set(DESCRIPTION, book.getDescription());
        update.set(CONTENT, book.getContent());
        mongoOperations.updateFirst(query, update, Book.class);
        Book bookUpdate = bookRepository.findById(book.getId()).get();
        return bookUpdate;
    }

    @PostMapping("/editGenreBook")
    public Book editGenreBook(@RequestParam String id, @RequestBody String genreId){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(id));
        Update update  = new Update();
        Genre genre = genreRepository.findById(genreId).get();
        update.set(GENRE, genre);
        mongoOperations.updateFirst(query, update, Book.class);
        Book bookUpdate = bookRepository.findById(id).get();
        return bookUpdate;
    }

    @DeleteMapping("/deleteAuthorFromBook/{id}")
    public List<Author> deleteAuthorFromBook(@PathVariable String id, @RequestBody Author author){
        Book book = bookRepository.findById(id).get();
        book.getAuthors().remove(author);
        bookRepository.save(book);
        return (List<Author>)book.getAuthors();
    }

    @PostMapping("/addAuthorInBook")
    public String addAuthorInBook(@RequestParam String id, @RequestBody String authorId){
        Book book = bookRepository.findById(id).get();
        Author author = authorRepository.findById(authorId).get();
        book.setAuthor(author);
        bookRepository.save(book);
        return "book?id="+id;
    }

    @DeleteMapping("/deleteCommentFromBook/{id}")
    public List<Comment> deleteCommentFromBook(@PathVariable String id, @RequestBody Comment comment){
        Book book = bookRepository.findById(id).get();
        book.getComments().remove(comment);
        bookRepository.save(book);
        return (List<Comment>)book.getComments();
    }

    @PostMapping("/addCommentInBook")
    public String addCommentInBook(@RequestParam String id, @RequestBody Comment comment){
        Book book = bookRepository.findById(id).get();
        comment = commentRepository.save(comment);
        book.setComment(comment);
        bookRepository.save(book);
        return "book?id="+id;
    }
}
