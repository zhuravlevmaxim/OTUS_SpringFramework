package ru.otus.lesson31hw.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
import ru.otus.lesson31hw.domain.Author;
import ru.otus.lesson31hw.domain.Book;
import ru.otus.lesson31hw.domain.Comment;
import ru.otus.lesson31hw.domain.Genre;
import ru.otus.lesson31hw.service.BookService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
@WithUserDetails
@ContextConfiguration
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;

    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String COMMENT = "comment";
    private static final String GENRE = "genre";
    private static final String BOOK_NAME = "bookName";
    private static final String BOOK_DESCRIPTION = "bookDescription";
    private static final String BOOK_CONTENT = "bookContent";
    private static final String ID = "0";

    private Author author;
    private Book book;
    private Comment comment;
    private Genre genre;
    private List<Book> books;

    @Before
    public void init(){
        book = new Book();

        author = new Author();
        author.setId(ID);
        author.setFirstName(FIRST_NAME);
        author.setSecondName(SECOND_NAME);

        comment = new Comment();
        comment.setId(ID);
        comment.setComment(COMMENT);

        genre = new Genre();
        genre.setId(ID);
        genre.setGenre(GENRE);

        book.setId(ID);
        book.setName(BOOK_NAME);
        book.setContent(BOOK_CONTENT);
        book.setDescription(BOOK_DESCRIPTION);
        book.setAuthor(author);
        book.setComment(comment);
        book.setGenre(genre);

        books = Arrays.asList(book);
    }

    @Test
    public void testGetBooks() throws Exception {
        Mockito.when(bookService.getBooks()).thenReturn(books);
        this.mockMvc.perform(post("/books").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Mockito.when(bookService.deleteBook(ID)).thenReturn(books);
        this.mockMvc.perform(delete("/books/" +ID).with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void testEditBook() throws Exception {
        Mockito.when(bookService.editBook(book)).thenReturn(book);
        this.mockMvc.perform(put("/books").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(book))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testEditGenreInBook() throws Exception {
        Mockito.when(bookService.editGenreInBook(ID, genre)).thenReturn(book);
        this.mockMvc.perform(put("/books/"+ID+"/editGenreInBook").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(genre))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAuthorInBook() throws Exception {
        Mockito.when(bookService.addAuthorInBook(ID, author)).thenReturn(book);
        this.mockMvc.perform(put("/books/"+ID+"/addAuthorInBook").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(author))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAuthorFromBook() throws Exception {
        Mockito.when(bookService.deleteAuthorFromBook(ID, author)).thenReturn(book);
        this.mockMvc.perform(put("/books/"+ID+"/deleteAuthorFromBook").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(author))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testAddCommentInBook() throws Exception {
        Mockito.when(bookService.addCommentInBook(ID, comment)).thenReturn(book);
        this.mockMvc.perform(put("/books/"+ID+"/addCommentInBook").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(comment))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCommentFromBook() throws Exception {
        Mockito.when(bookService.deleteCommentFromBook(ID, comment)).thenReturn(book);
        this.mockMvc.perform(put("/books/"+ID+"/deleteCommentFromBook").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(comment))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateNewBook() throws Exception {
        Mockito.when(bookService.createNewBook(book)).thenReturn(books);
        this.mockMvc.perform(post("/books/createNewBook").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(book))
        )
                .andExpect(status().isOk());
    }

    private static String objectToStringJSON(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.write(object, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}