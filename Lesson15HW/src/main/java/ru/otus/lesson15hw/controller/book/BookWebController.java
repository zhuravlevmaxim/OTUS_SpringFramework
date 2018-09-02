package ru.otus.lesson15hw.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.domain.Book;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.AuthorRepository;
import ru.otus.lesson15hw.repository.BookRepository;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.List;

@Controller
public class BookWebController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String books(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "/books";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String books(@RequestParam String id, Model model){
        Book book = bookRepository.findById(id).get();
        List<Genre> genres = genreRepository.findAll();
        List<Author> authors = authorRepository.findAll();
        authors.removeAll(book.getAuthors());
        model.addAttribute("book", book);
        model.addAttribute("genres", genres);
        model.addAttribute("authors", authors);
        return "/book";
    }
    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public String deleteBook(@RequestParam String id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
