package ru.otus.lesson21hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson21hw.domain.Author;
import ru.otus.lesson21hw.domain.Book;
import ru.otus.lesson21hw.domain.Comment;
import ru.otus.lesson21hw.domain.Genre;
import ru.otus.lesson21hw.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody List<Book> deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
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
    public @ResponseBody List<Book> createNewBook(@RequestBody Book book){
        return bookService.createNewBook(book);
    }
}
