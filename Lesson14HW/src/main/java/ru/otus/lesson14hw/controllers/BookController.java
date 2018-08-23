package ru.otus.lesson14hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson14hw.domain.Book;
import ru.otus.lesson14hw.repository.BookRepository;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public String books(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping("/book")
    public String book(@RequestParam String id, Model model){
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        return "book";
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.POST)
    public String saveNewBook(@ModelAttribute(value = "book") Book book){
        bookRepository.save(book);
        String id = book.getId();
        return "redirect:/book?id=" + id;
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam String id){
        bookRepository.deleteById(id);
        return "/books";
    }
}
