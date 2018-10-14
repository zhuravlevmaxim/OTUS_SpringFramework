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
import ru.otus.lesson15hw.controller.genre.GenreRestController;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreRestController.class)
public class GenreRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreRepository genreRepository;
    @MockBean
    private MongoOperations mongoOperations;

    @Test
    public void testAddGenre() throws Exception {
        Genre genre = new Genre("genre");
        List<Genre> genres = Arrays.asList(genre);
        Mockito.when(genreRepository.findAll()).thenReturn(genres);
        this.mockMvc.perform(post("/addGenre", genre)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"0\", \"firstName\":\"genre\"}")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].genre", is(genre.getGenre())));
    }

    @Test
    public void testDeleteGenre() throws Exception {
        Genre genre = new Genre("genre");
        List<Genre> genres = Arrays.asList(genre);
        Mockito.when(genreRepository.findAll()).thenReturn(genres);
        this.mockMvc.perform(delete("/deleteGenre/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].genre", is(genre.getGenre())));
    }

    @Test
    public void testEditGenre() throws Exception {
        Genre genre = new Genre("genre");
        Mockito.when(genreRepository.findById("0")).thenReturn(Optional.of(genre));
        this.mockMvc.perform(put("/editGenre")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"0\", \"genre\":\"genre\"}")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("[\"genre\"]", is(genre.getGenre())));
    }
}
