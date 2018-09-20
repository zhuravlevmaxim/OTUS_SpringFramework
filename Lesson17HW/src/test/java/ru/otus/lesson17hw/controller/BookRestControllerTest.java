package ru.otus.lesson17hw.controller;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.service.BookService;

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
    private static String CONTENT_AUTHOR = "{\"id\":\"0\", \"firstName\":\"firstName\", \"secondName\":\"secondName\"}";
    private static String CONTENT_COMMENT = "{\"id\":\"0\", \"comment\":\"comment\"}";
    private static String CONTENT_GENRE = "{\"id\":\"0\", \"genre\":\"genre\"}";

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
        //author = authorRepository.save(author);

        comment = new Comment();
        comment.setId(ID);
        comment.setComment(COMMENT);
        //comment = commentRepository.save(comment);

        genre = new Genre();
        genre.setId(ID);
        genre.setGenre(GENRE);
        //genre = genreRepository.save(genre);

        book.setId(ID);
        book.setName(BOOK_NAME);
        book.setContent(BOOK_CONTENT);
        book.setDescription(BOOK_DESCRIPTION);
        book.setAuthor(author);
        book.setComment(comment);
        book.setGenre(genre);
    }

    /*
        @PostMapping
    public Flux<Book> getBooks(){
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Flux<Book> deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }

    @PutMapping
    public @ResponseBody Mono<Book> editBook(@RequestBody Book book){
        return bookService.editBook(book);
    }

    @PutMapping("/{id}/editGenreInBook")
    public @ResponseBody Mono<Book> editGenreInBook(@PathVariable String id, @RequestBody Genre genre){
        return bookService.editGenreInBook(id, genre);
    }

    @PutMapping("/{id}/addAuthorInBook")
    public @ResponseBody Mono<Book> addAuthorInBook(@PathVariable String id, @RequestBody Author author){
        return bookService.addAuthorInBook(id, author);
    }

    @PutMapping("/{id}/deleteAuthorFromBook")
    public @ResponseBody Mono<Book> deleteAuthorFromBook(@PathVariable String id, @RequestBody Author author){
        return bookService.deleteAuthorFromBook(id, author);
    }

    @PutMapping("/{id}/addCommentInBook")
    public @ResponseBody Mono<Book> addCommentInBook(@PathVariable String id, @RequestBody Comment comment){
        return bookService.addCommentInBook(id, comment);
    }

    @PutMapping("/{id}/deleteCommentFromBook")
    public @ResponseBody Mono<Book> deleteCommentFromBook(@PathVariable String id, @RequestBody Comment comment){
        return bookService.deleteCommentFromBook(id, comment);
    }

    @PostMapping("/createNewBook")
    public @ResponseBody Flux<Book> createNewBook(@RequestBody Book book){
        return bookService.createNewBook(book);
    }
    */
}
