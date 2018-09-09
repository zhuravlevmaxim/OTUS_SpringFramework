package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.repository.GenreRepository;

import java.util.List;

@RestController
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/genres")
    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    @DeleteMapping("/genres/{id}")
    public List<Genre> deleteGenre(@PathVariable String id){
        genreRepository.deleteById(id);
        return genreRepository.findAll();
    }
}
