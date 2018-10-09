package ru.otus.lesson17hw.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;

@RunWith(SpringRunner.class)
@DataMongoTest
public class BookRepositoryTest {
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String COMMENT = "comment";
    private static final String GENRE = "genre";
    private static final String BOOK_NAME = "bookName";
    private static final String BOOK_DESCRIPTION = "bookDescription";
    private static final String BOOK_CONTENT = "bookContent";

    @Autowired
    private BookReactiveRepository bookRepository;
    @Autowired
    private AuthorReactiveRepository authorRepository;
    @Autowired
    private GenreReactiveRepository genreRepository;
    @Autowired
    private CommentReactiveRepository commentRepository;

    private Author author;
    private Book book;
    private Comment comment;
    private Genre genre;

    @Before
    public void init(){
        author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setSecondName(SECOND_NAME);
        author = authorRepository.save(author).block();

        comment = new Comment();
        comment.setComment(COMMENT);
        comment = commentRepository.save(comment).block();

        genre = new Genre();
        genre.setGenre(GENRE);
        genre = genreRepository.save(genre).block();

        book = new Book();
        book.setName(BOOK_NAME);
        book.setContent(BOOK_CONTENT);
        book.setDescription(BOOK_DESCRIPTION);
        book.setAuthor(author);
        book.setComment(comment);
        book.setGenre(genre);

        book = bookRepository.save(book).block();
    }

    @After
    public void destroy(){
        bookRepository.deleteAll().block();
        authorRepository.deleteAll().block();
        genreRepository.deleteAll().block();
        commentRepository.deleteAll().block();
    }

    @Test
    public void testBookValues(){
        Assert.assertTrue(BOOK_NAME.equals(book.getName()));
        Assert.assertTrue(BOOK_DESCRIPTION.equals(book.getDescription()));
        Assert.assertTrue(BOOK_CONTENT.equals(book.getContent()));
    }

    @Test
    public void testAuthor(){
        Assert.assertNotNull(book.getAuthors());
        Assert.assertFalse(book.getAuthors().isEmpty());
    }

    @Test
    public void testComment(){
        Assert.assertNotNull(book.getComments());
        Assert.assertFalse(book.getComments().isEmpty());
    }

    @Test
    public void testGenre(){
        Assert.assertNotNull(book.getGenre());
    }

    @Test
    public void testCount(){
        Assert.assertEquals(bookRepository.count().block().intValue(), 1);
    }

    @Test
    public void testDeleteAll(){
        bookRepository.deleteAll().block();
        Assert.assertEquals(bookRepository.count().block().intValue(), 0);
    }
}
