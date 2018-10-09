package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreRestController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public @ResponseBody Flux<Genre> getGenres(){
        return genreService.getGenres();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Flux<Genre> deleteGenre(@PathVariable String id){
        return genreService.deleteGenre(id);
    }
    @PutMapping
    public @ResponseBody
    Mono<Genre> editGenre(@RequestBody Genre genre){
        return genreService.editGenre(genre);
    }

    @PostMapping("/createNewGenre")
    public @ResponseBody Flux<Genre> createNewGenre(@RequestBody Genre genre){
        return genreService.createNewGenre(genre);
    }
}