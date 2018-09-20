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
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.service.GenreService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreRestController.class)
public class GenreRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreService genreService;

    private Genre genre;
    private List<Genre> genres;

    private static String CONTENT = "{\"id\":\"0\", \"genre\":\"genre\"}";
    private static final String GENRE = "genre";
    private static final String ID = "0";

    @Before
    public void init(){
        genre = new Genre(GENRE);
        genres = Arrays.asList(genre);
    }

    @Test
    public void testGetGenres() throws Exception {
        Mockito.when(genreService.getGenres()).thenReturn(Flux.fromStream(genres.stream()));
        this.mockMvc.perform(post("/genres")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteGenre() throws Exception {
        Mockito.when(genreService.getGenres()).thenReturn(Flux.fromStream(genres.stream()));
        this.mockMvc.perform(delete("/genres/" +ID)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testEditGenre() throws Exception {
        Mockito.when(genreService.getGenres()).thenReturn(Flux.fromStream(genres.stream()));
        this.mockMvc.perform(put("/genres")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateNewGenre() throws Exception {
        Mockito.when(genreService.getGenres()).thenReturn(Flux.fromStream(genres.stream()));
        this.mockMvc.perform(post("/genres/createNewGenre")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT)
        )
                .andExpect(status().isOk());
    }
}
