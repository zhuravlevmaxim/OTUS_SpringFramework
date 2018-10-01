package ru.otus.lesson15hw.controller.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.lesson15hw.controller.author.AuthorWebController;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.repository.AuthorRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorWebController.class)
public class AuthorWebControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthorRepository authorRepository;

    @Test
    public void testAuthorsView() throws Exception {
        this.mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("authors"))
                .andDo(print());
    }
    @Test
    public void testAuthorView() throws Exception {
        Author author = new Author();
        Mockito.when(authorRepository.findById("0")).thenReturn(java.util.Optional.ofNullable(author));

        this.mockMvc.perform(get("/author").param("id", "0"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("author"))
                .andDo(print());
    }
}
