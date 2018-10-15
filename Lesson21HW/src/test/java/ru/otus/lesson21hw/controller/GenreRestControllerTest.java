package ru.otus.lesson21hw.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.lesson21hw.domain.Genre;
import ru.otus.lesson21hw.service.GenreService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreRestController.class)
@WithUserDetails
@ContextConfiguration
public class GenreRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreService genreService;

    private Genre genre;
    private List<Genre> genres;

    private static final String ID = "0";
    private static final String GENRE = "genre";

    @Before
    public void init(){
        genre = new Genre(GENRE);
        genres = Arrays.asList(genre);
    }

    @Test
    public void getGenresTest() throws Exception {
        when(genreService.getGenres()).thenReturn(genres);
        mockMvc.perform(post("/genres").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(genres)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].genre", is(GENRE)));
    }

    @Test
    public void deleteGenreTest() throws Exception {
        when(genreService.deleteGenre(ID)).thenReturn(genres);
        mockMvc.perform(delete("/genres/"+ID).with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(genres)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].genre", is(GENRE)));
    }

    @Test
    public void editGenreTest() throws Exception {
        when(genreService.editGenre(genre)).thenReturn(genre);
        mockMvc.perform(put("/genres").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(genre)))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("[\"genre\"]", is(GENRE)));
    }

    @Test
    public void createNewGenreTest() throws Exception {
        when(genreService.createNewGenre(genre)).thenReturn(genres);
        mockMvc.perform(post("/genres/createNewGenre").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(genre)))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$", hasSize(0)))
                //.andExpect(jsonPath("$[0].genre", is(GENRE)));
    }

    private static String objectToStringJSON(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
