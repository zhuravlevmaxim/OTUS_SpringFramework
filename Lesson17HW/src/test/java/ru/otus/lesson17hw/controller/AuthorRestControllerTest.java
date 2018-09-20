package ru.otus.lesson17hw.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Flux;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.service.AuthorService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorRestController.class)
public class AuthorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthorService authorService;

    private Author author;
    private List<Author> authors;

    private static String CONTENT = "{\"id\":\"0\", \"firstName\":\"firstName\", \"secondName\":\"secondName\"}";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String ID = "0";

    @Before
    public void init(){
        author = new Author(FIRST_NAME, SECOND_NAME);
        authors = Arrays.asList(author);
    }

    @Test
    public void testGetAuthors() throws Exception {
        Mockito.when(authorService.getAuthors()).thenReturn(Flux.fromStream(authors.stream()));
        this.mockMvc.perform(post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        Mockito.when(authorService.deleteAuthor(ID)).thenReturn(Flux.fromStream(authors.stream()));
        this.mockMvc.perform(delete("/authors/" + ID)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testEditAuthor() throws Exception {
        Mockito.when(authorService.editAuthor(author)).thenReturn(Flux.fromStream(authors.stream()).elementAt(0));
        this.mockMvc.perform(put("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateNewAuthor() throws Exception {
        Mockito.when(authorService.createNewAuthor(author)).thenReturn(Flux.fromStream(authors.stream()));
        this.mockMvc.perform(post("/authors/createNewAuthor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT)
        )
                .andExpect(status().isOk());
    }
}
