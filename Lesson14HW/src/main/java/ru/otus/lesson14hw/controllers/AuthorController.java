package ru.otus.lesson14hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson14hw.domain.Author;
import ru.otus.lesson14hw.repository.AuthorRepository;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/author")
    public String author(@RequestParam String id, Model model){
        Author author = authorRepository.findById(id).get();
        model.addAttribute("author", author);
        return "author";
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    public String deleteAuthor(@RequestParam String id){
        authorRepository.deleteById(id);
        return "redirect:books";
    }

    @RequestMapping(value = "/editAuthor", method = RequestMethod.POST)
    public String editAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        String id = author.getId();
        return "redirect:/author?id=" + id;
    }

    @RequestMapping(value = "/createAuthor", method = RequestMethod.POST)
    public String createAuthor(@RequestParam String idBook, @ModelAttribute Author author){

        return "redirect:/book?id=" + idBook;
    }
}
