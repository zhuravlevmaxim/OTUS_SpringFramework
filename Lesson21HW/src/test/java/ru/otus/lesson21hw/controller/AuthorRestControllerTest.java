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
import ru.otus.lesson21hw.domain.Author;
import ru.otus.lesson21hw.service.AuthorService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorRestController.class)
@WithUserDetails
@ContextConfiguration
public class AuthorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthorService authorService;

    private Author author;
    private List<Author> authors;

    private static final String ID = "0";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";

    @Before
    public void init(){
        author = new Author(FIRST_NAME, SECOND_NAME);
        authors = Arrays.asList(author);
    }

    @Test
    public void getAuthorsTest() throws Exception {
        when(authorService.getAuthors()).thenReturn(authors);
        mockMvc.perform(post("/authors").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(authors)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(FIRST_NAME)))
                .andExpect(jsonPath("$[0].secondName", is(SECOND_NAME)));
    }

    @Test
    public void deleteAuthorTest() throws Exception {
        when(authorService.deleteAuthor(ID)).thenReturn(authors);
        mockMvc.perform(delete("/authors/"+ID).with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(authors)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(FIRST_NAME)))
                .andExpect(jsonPath("$[0].secondName", is(SECOND_NAME)));
    }

    @Test
    public void editAuthorTest() throws Exception {
        when(authorService.editAuthor(author)).thenReturn(author);
        mockMvc.perform(put("/authors").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[\"firstName\"]", is(FIRST_NAME)))
                .andExpect(jsonPath("[\"secondName\"]", is(SECOND_NAME)));
    }

    @Test
    public void createNewAuthorTest() throws Exception {
        when(authorService.createNewAuthor(author)).thenReturn(authors);
        mockMvc.perform(post("/authors/createNewAuthor").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(FIRST_NAME)))
                .andExpect(jsonPath("$[0].secondName", is(SECOND_NAME)));
    }

    private static String objectToStringJSON(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
