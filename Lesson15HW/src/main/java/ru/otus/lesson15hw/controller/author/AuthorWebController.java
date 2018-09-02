package ru.otus.lesson15hw.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.repository.AuthorRepository;

import java.util.List;

@Controller
public class AuthorWebController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public String authors(Model model){
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

}
