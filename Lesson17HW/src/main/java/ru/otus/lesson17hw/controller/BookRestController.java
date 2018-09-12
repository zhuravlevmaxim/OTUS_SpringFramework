package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Flux<Book> getBooks(){
        return Flux.fromStream(bookService.getBooks().stream());
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Flux<Book> deleteBook(@PathVariable String id){
        return Flux.fromStream(bookService.deleteBook(id).stream());
    }

    @PutMapping
    public @ResponseBody Book editBook(@RequestBody Book book){
        return bookService.editBook(book);
    }

    @PutMapping("/{id}/editGenreInBook")
    public @ResponseBody Book editGenreInBook(@PathVariable String id, @RequestBody Genre genre){
        return bookService.editGenreInBook(id, genre);
    }

    @PutMapping("/{id}/addAuthorInBook")
    public @ResponseBody Book addAuthorInBook(@PathVariable String id, @RequestBody Author author){
        return bookService.addAuthorInBook(id, author);
    }

    @PutMapping("/{id}/deleteAuthorFromBook")
    public @ResponseBody Book deleteAuthorFromBook(@PathVariable String id, @RequestBody Author author){
        return bookService.deleteAuthorFromBook(id, author);
    }

    @PutMapping("/{id}/addCommentInBook")
    public @ResponseBody Book addCommentInBook(@PathVariable String id, @RequestBody Comment comment){
        return bookService.addCommentInBook(id, comment);
    }

    @PutMapping("/{id}/deleteCommentFromBook")
    public @ResponseBody Book deleteCommentFromBook(@PathVariable String id, @RequestBody Comment comment){
        return bookService.deleteCommentFromBook(id, comment);
    }

    @PostMapping("/createNewBook")
    public @ResponseBody Flux<Book> createNewBook(@RequestBody Book book){
        return Flux.fromStream(bookService.createNewBook(book).stream());
    }
}