package ru.otus.lesson15hw.controller.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.List;

@RestController
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/addGenre")
    public List<Genre> addGenre(@RequestBody Genre genre){
        genreRepository.save(genre);
        return genreRepository.findAll();
    }

    @DeleteMapping("/deleteGenre/{genreId}")
    public List<Genre> deleteGenre(@PathVariable String genreId){
        genreRepository.deleteById(genreId);
        return genreRepository.findAll();
    }
}
