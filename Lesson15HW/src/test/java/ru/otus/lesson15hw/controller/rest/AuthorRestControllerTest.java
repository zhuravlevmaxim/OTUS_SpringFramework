package ru.otus.lesson15hw.controller.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.lesson15hw.controller.author.AuthorRestController;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.repository.AuthorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorRestController.class)
public class AuthorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MongoOperations mongoOperations;
    @MockBean
    private AuthorRepository authorRepository;

    @Test
    public void testAddAuthor() throws Exception {
        Author author = new Author("firstName", "secondName");
        List<Author> authors = Arrays.asList(author);
        Mockito.when(authorRepository.findAll()).thenReturn(authors);
        this.mockMvc.perform(post("/addAuthor", author)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"0\", \"firstName\":\"firstName\", \"secondName\":\"secondName\"}")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(author.getFirstName())))
                .andExpect(jsonPath("$[0].secondName", is(author.getSecondName())));
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        Author author = new Author("firstName", "secondName");
        List<Author> authors = Arrays.asList(author);
        Mockito.when(authorRepository.findAll()).thenReturn(authors);
        this.mockMvc.perform(delete("/deleteAuthor/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(author.getFirstName())))
                .andExpect(jsonPath("$[0].secondName", is(author.getSecondName())));
    }

    @Test
    public void testEditAuthor() throws Exception {
        Author author = new Author("firstName", "secondName");
        Mockito.when(authorRepository.findById("0")).thenReturn(Optional.of(author));
        this.mockMvc.perform(put("/editAuthor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"0\", \"firstName\":\"firstName\", \"secondName\":\"secondName\"}")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("[\"firstName\"]", is(author.getFirstName())))
                .andExpect(jsonPath("[\"secondName\"]", is(author.getSecondName())));
    }
}
