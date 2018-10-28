package ru.otus.lesson29hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson29hw.domain.Genre;
import ru.otus.lesson29hw.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreRestController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public @ResponseBody List<Genre> getGenres(){
        return genreService.getGenres();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody List<Genre> deleteGenre(@PathVariable String id){
        return genreService.deleteGenre(id);
    }
    @PutMapping
    public @ResponseBody Genre editGenre(@RequestBody Genre genre){
        return genreService.editGenre(genre);
    }

    @PostMapping("/createNewGenre")
    public @ResponseBody List<Genre> createNewGenre(@RequestBody Genre genre){
        return genreService.createNewGenre(genre);
    }
}