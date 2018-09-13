package ru.otus.lesson19hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson19hw.domain.Author;
import ru.otus.lesson19hw.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public @ResponseBody List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody List<Author> deleteAuthor(@PathVariable String id){
        return authorService.deleteAuthor(id);
    }

    @PutMapping
    public @ResponseBody Author editAuthor(@RequestBody Author author){
        return authorService.editAuthor(author);
    }

    @PostMapping("/createNewAuthor")
    public @ResponseBody List<Author> createNewAuthor(@RequestBody Author author){
        return authorService.createNewAuthor(author);
    }
}
