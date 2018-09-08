package ru.otus.lesson15hw.controller.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.lesson15hw.controller.book.BookWebController;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.domain.Book;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.AuthorRepository;
import ru.otus.lesson15hw.repository.BookRepository;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(BookWebController.class)
public class BookWebControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookRepository bookRepository;
    @MockBean
    private GenreRepository genreRepository;
    @MockBean
    private AuthorRepository authorRepository;

    @Test
    public void testBooksView() throws Exception {
        List<Book> books = Collections.EMPTY_LIST;
        Mockito.when(bookRepository.findAll()).thenReturn(books);
        this.mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("books"))
                .andDo(print());
    }

    @Test
    public void testBookView() throws Exception {
        Book book = new Book();
        List<Author> authors = Collections.EMPTY_LIST;
        List<Genre> genres = Collections.EMPTY_LIST;
        Mockito.when(bookRepository.findById("0")).thenReturn(Optional.of(book));
        Mockito.when(authorRepository.findAll()).thenReturn(authors);
        Mockito.when(genreRepository.findAll()).thenReturn(genres);
        this.mockMvc.perform(get("/book").param("id", "0"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("book"))
                .andDo(print());
    }

    @Test
    public void testDeleteBookView() throws Exception {
        this.mockMvc.perform(post("/deleteBook").param("id", "0"))
                .andDo(print())
                .andExpect(redirectedUrl("/books"))
                .andDo(print());
    }

    @Test
    public void testCreateBookView() throws Exception {
        List<Author> authors = Collections.EMPTY_LIST;
        List<Genre> genres = Collections.EMPTY_LIST;
        Mockito.when(authorRepository.findAll()).thenReturn(authors);
        Mockito.when(genreRepository.findAll()).thenReturn(genres);
        this.mockMvc.perform(get("/createBook"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("createBook"))
                .andDo(print());
    }
}
