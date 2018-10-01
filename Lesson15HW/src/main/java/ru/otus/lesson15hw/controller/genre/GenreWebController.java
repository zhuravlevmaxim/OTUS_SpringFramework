package ru.otus.lesson15hw.controller.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.List;

@Controller
public class GenreWebController {

    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping("/genres")
    public String genres(Model model){
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @RequestMapping("/genre")
    public String genres(@RequestParam String id, Model model){
        Genre genre = genreRepository.findById(id).get();
        model.addAttribute("genre", genre);
        return "genre";
    }
}
