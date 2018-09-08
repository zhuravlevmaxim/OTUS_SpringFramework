package ru.otus.lesson15hw.controller.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
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
import ru.otus.lesson15hw.controller.book.BookRestController;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.domain.Book;
import ru.otus.lesson15hw.domain.Comment;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.AuthorRepository;
import ru.otus.lesson15hw.repository.BookRepository;
import ru.otus.lesson15hw.repository.CommentRepository;
import ru.otus.lesson15hw.repository.GenreRepository;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MongoOperations mongoOperations;
    @MockBean
    private BookRepository bookRepository;
    @MockBean
    private GenreRepository genreRepository;
    @MockBean
    private AuthorRepository authorRepository;
    @MockBean
    private CommentRepository commentRepository;

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

    @Before
    public void init(){
        book = new Book();
        author = new Author();
        author.setId(ID);
        author.setFirstName(FIRST_NAME);
        author.setSecondName(SECOND_NAME);
        author = authorRepository.save(author);

        comment = new Comment();
        comment.setId(ID);
        comment.setComment(COMMENT);
        comment = commentRepository.save(comment);

        genre = new Genre();
        genre.setId(ID);
        genre.setGenre(GENRE);
        genre = genreRepository.save(genre);

        book.setId(ID);
        book.setName(BOOK_NAME);
        book.setContent(BOOK_CONTENT);
        book.setDescription(BOOK_DESCRIPTION);
        book.setAuthor(author);
        book.setComment(comment);
        book.setGenre(genre);
    }

//    @After
//    public void destroy(){
//        book = null;
//    }

    @Test
    public void testEditBook() throws Exception {
        Mockito.when(bookRepository.findById(ID)).thenReturn(Optional.of(book));
        this.mockMvc.perform(post("/editBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(book))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("[\"id\"]", is(book.getId())))
                .andExpect(jsonPath("[\"name\"]", is(book.getName())))
                .andExpect(jsonPath("[\"description\"]", is(book.getDescription())))
                .andExpect(jsonPath("[\"content\"]", is(book.getContent())));
    }

    @Test
    public void testSaveBook() throws Exception {
        Author author = new Author(FIRST_NAME, SECOND_NAME);
        book.setAuthor(author);
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        this.mockMvc.perform(put("/saveBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(book))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("[\"id\"]", is(book.getId())))
                .andExpect(jsonPath("[\"name\"]", is(book.getName())))
                .andExpect(jsonPath("[\"description\"]", is(book.getDescription())))
                .andExpect(jsonPath("[\"content\"]", is(book.getContent())))
                .andExpect(jsonPath("[\"authors\"]", hasSize(1)));
    }

    private static String objectToStringJSON(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
