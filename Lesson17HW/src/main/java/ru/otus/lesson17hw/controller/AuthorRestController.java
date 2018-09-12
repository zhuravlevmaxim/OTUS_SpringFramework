package ru.otus.lesson17hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public @ResponseBody Flux<Author> getAuthors(){
        return Flux.fromStream(authorService.getAuthors().stream());
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Flux<Author> deleteAuthor(@PathVariable String id){
        return Flux.fromStream(authorService.deleteAuthor(id).stream());
    }

    @PutMapping
    public @ResponseBody Author editAuthor(@RequestBody Author author){
        return authorService.editAuthor(author);
    }

    @PostMapping("/createNewAuthor")
    public @ResponseBody Flux<Author> createNewAuthor(@RequestBody Author author){
        return Flux.fromStream(authorService.createNewAuthor(author).stream());
    }
}
