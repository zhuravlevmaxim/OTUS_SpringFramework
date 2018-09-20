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
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.service.BookService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
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
    private static final String CONTENT_BOOK = "{\"id\":\"0\", \"name\":\"nameBook\"," +
            "\"content\":\"contentBook\", \"description\":\"descriptionBook\"," +
            "\"genre\":{\"id\":\"0\", \"genre\":\"genre\"}," +
            "\"authors\":[{\"id\":\"0\", \"firstName\":\"firstName\", \"secondName\":\"secondName\"}]," +
            "\"comments\":[{\"id\":\"0\", \"comment\":\"comment\"}]}";
    private static String CONTENT_AUTHOR = "{\"id\":\"0\", \"firstName\":\"firstName\", \"secondName\":\"secondName\"}";
    private static String CONTENT_COMMENT = "{\"id\":\"0\", \"comment\":\"comment\"}";
    private static String CONTENT_GENRE = "{\"id\":\"0\", \"genre\":\"genre\"}";

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
        Mockito.when(bookService.getBooks()).thenReturn(Flux.fromStream(books.stream()));
        this.mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook() throws Exception {
        Mockito.when(bookService.deleteBook(ID)).thenReturn(Flux.fromStream(books.stream()));
        this.mockMvc.perform(delete("/books/" +ID)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testEditBook() throws Exception {
        Mockito.when(bookService.editBook(book)).thenReturn(Flux.fromStream(books.stream()).elementAt(0));
        this.mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_BOOK)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testEditGenreInBook() throws Exception {
        Mockito.when(bookService.editGenreInBook(ID, genre)).thenReturn(Flux.fromStream(books.stream()).elementAt(0));
        this.mockMvc.perform(put("/books/"+ID+"/editGenreInBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_GENRE)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAuthorInBook() throws Exception {
        Mockito.when(bookService.addAuthorInBook(ID, author)).thenReturn(Flux.fromStream(books.stream()).elementAt(0));
        this.mockMvc.perform(put("/books/"+ID+"/addAuthorInBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_AUTHOR)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAuthorFromBook() throws Exception {
        Mockito.when(bookService.deleteAuthorFromBook(ID, author)).thenReturn(Flux.fromStream(books.stream()).elementAt(0));
        this.mockMvc.perform(put("/books/"+ID+"/deleteAuthorFromBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_AUTHOR)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testAddCommentInBook() throws Exception {
        Mockito.when(bookService.addCommentInBook(ID, comment)).thenReturn(Flux.fromStream(books.stream()).elementAt(0));
        this.mockMvc.perform(put("/books/"+ID+"/addCommentInBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_COMMENT)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCommentFromBook() throws Exception {
        Mockito.when(bookService.deleteCommentFromBook(ID, comment)).thenReturn(Flux.fromStream(books.stream()).elementAt(0));
        this.mockMvc.perform(put("/books/"+ID+"/deleteCommentFromBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_COMMENT)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateNewBook() throws Exception {
        Mockito.when(bookService.createNewBook(book)).thenReturn(Flux.fromStream(books.stream()));
        this.mockMvc.perform(post("/books/createNewBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CONTENT_BOOK)
        )
                .andExpect(status().isOk());
    }
}
