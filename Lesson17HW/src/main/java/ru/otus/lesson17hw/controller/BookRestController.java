package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.repository.BookRepository;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

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
    public @ResponseBody Book editBook(@ModelAttribute Book book){
//        bookRepository.deleteById(id);
        return bookRepository.findById(book.getId()).get();
    }
}
