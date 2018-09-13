package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.service.BookService;

//@RestController
//@RequestMapping("/books")
public class BookRestController {

//    @Autowired
//    private BookService bookService;
//
//    @PostMapping
//    public Flux<Book> getBooks(){
//        return Flux.fromStream(bookService.getBooks().stream());
//    }
//
//    @DeleteMapping("/{id}")
//    public @ResponseBody Flux<Book> deleteBook(@PathVariable String id){
//        return Flux.fromStream(bookService.deleteBook(id).stream());
//    }
//
//    @PutMapping
//    public @ResponseBody Mono<Book> editBook(@RequestBody Book book){
//        return Mono.create(value -> bookService.editBook(book));
//    }
//
//    @PutMapping("/{id}/editGenreInBook")
//    public @ResponseBody Mono<Book> editGenreInBook(@PathVariable String id, @RequestBody Genre genre){
//        return Mono.create(value -> bookService.editGenreInBook(id, genre));
//    }
//
//    @PutMapping("/{id}/addAuthorInBook")
//    public @ResponseBody Mono<Book> addAuthorInBook(@PathVariable String id, @RequestBody Author author){
//        return Mono.create(value -> bookService.addAuthorInBook(id, author));
//    }
//
//    @PutMapping("/{id}/deleteAuthorFromBook")
//    public @ResponseBody Mono<Book> deleteAuthorFromBook(@PathVariable String id, @RequestBody Author author){
//        return Mono.create(value -> bookService.deleteAuthorFromBook(id, author));
//    }
//
//    @PutMapping("/{id}/addCommentInBook")
//    public @ResponseBody Mono<Book> addCommentInBook(@PathVariable String id, @RequestBody Comment comment){
//        return Mono.create(value -> bookService.addCommentInBook(id, comment));
//    }
//
//    @PutMapping("/{id}/deleteCommentFromBook")
//    public @ResponseBody Mono<Book> deleteCommentFromBook(@PathVariable String id, @RequestBody Comment comment){
//        return Mono.create(value -> bookService.deleteCommentFromBook(id, comment));
//    }
//
//    @PostMapping("/createNewBook")
//    public @ResponseBody Flux<Book> createNewBook(@RequestBody Book book){
//        return Flux.fromStream(bookService.createNewBook(book).stream());
//    }
}