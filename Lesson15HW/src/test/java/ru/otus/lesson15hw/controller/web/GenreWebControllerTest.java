package ru.otus.lesson15hw.controller.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.lesson15hw.controller.genre.GenreWebController;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.GenreRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreWebController.class)
public class GenreWebControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreRepository genreRepository;

    @Test
    public void testGenresView() throws Exception {
        this.mockMvc.perform(get("/genres"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("genres"))
                .andDo(print());
    }

    @Test
    public void testAuthorView() throws Exception {
        Genre genre = new Genre();
        Mockito.when(genreRepository.findById("0")).thenReturn(java.util.Optional.ofNullable(genre));

        this.mockMvc.perform(get("/genre").param("id", "0"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("genre"))
                .andDo(print());
    }
}
