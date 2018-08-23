package ru.otus.lesson14hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson14hw.domain.Genre;
import ru.otus.lesson14hw.repository.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping("/genre")
    public String author(@RequestParam String id, Model model){
        Genre genre = genreRepository.findById(id).get();
        model.addAttribute("genre", genre);
        return "genre";
    }

    @RequestMapping(value = "/editGenre", method = RequestMethod.POST)
    public String editAuthor(@ModelAttribute Genre genre){
        genreRepository.save(genre);
        String id = genre.getId();
        return "redirect:/genre?id=" + id;
    }
}
