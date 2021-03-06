package ru.otus.lesson15hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.lesson15hw.domain.Author;
import ru.otus.lesson15hw.domain.Book;
import ru.otus.lesson15hw.domain.Comment;
import ru.otus.lesson15hw.domain.Genre;
import ru.otus.lesson15hw.repository.AuthorRepository;
import ru.otus.lesson15hw.repository.BookRepository;
import ru.otus.lesson15hw.repository.CommentRepository;
import ru.otus.lesson15hw.repository.GenreRepository;

import java.util.Random;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(Main.class, args);
        /*
        BookRepository bookRepository = context.getBean(BookRepository.class);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        CommentRepository commentRepository = context.getBean(CommentRepository.class);
        GenreRepository genreRepository = context.getBean(GenreRepository.class);
        Book book = null;
        Author author = null;
        Genre genre = null;
        Comment comment = null;
        for(int bookCount = 0; bookCount < 10; bookCount++){
            int valuesLimit = new Random().nextInt(15) + 3;
            book = new Book();
            book.setContent("content: " +bookCount);
            book.setName("name: " + bookCount);
            book.setDescription("description: " + bookCount);
            genre = new Genre();
            genre.setGenre("genre: " + bookCount);
            genre = genreRepository.save(genre);
            book.setGenre(genre);
            for(int valuesCount = 0; valuesCount < valuesLimit; valuesCount++){
                author = new Author();
                author.setFirstName("firstName: " + bookCount + ":" + valuesCount);
                author.setSecondName("secondName: " + bookCount + ":" + valuesCount);
                author = authorRepository.save(author);
                book.setAuthor(author);
                comment = new Comment();
                comment.setComment("comment: "  + bookCount + ":" + valuesCount);
                comment = commentRepository.save(comment);
                book.setComment(comment);
            }
            bookRepository.save(book);
        }
        //*/
    }
}
