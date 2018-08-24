package ru.otus.lesson14hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson14hw.domain.Author;
import ru.otus.lesson14hw.domain.Book;
import ru.otus.lesson14hw.domain.Comment;
import ru.otus.lesson14hw.repository.AuthorRepository;
import ru.otus.lesson14hw.repository.BookRepository;
import ru.otus.lesson14hw.repository.CommentRepository;

import java.util.Collection;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CommentRepository commentRepository;

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
    public String editBook(@ModelAttribute(value = "book") Book book){
        Collection<Author> authors = book.getAuthors();
        Collection<Comment> comments = book.getComments();
        authorRepository.saveAll(authors);
        commentRepository.saveAll(comments);
        bookRepository.save(book);
        String id = book.getId();
        return "redirect:/book?id=" + id;
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam String id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
