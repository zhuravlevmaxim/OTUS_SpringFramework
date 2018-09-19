package ru.otus.lesson17hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.lesson17hw.domain.Author;
import ru.otus.lesson17hw.domain.Book;
import ru.otus.lesson17hw.domain.Comment;
import ru.otus.lesson17hw.domain.Genre;
import ru.otus.lesson17hw.repository.AuthorReactiveRepository;
import ru.otus.lesson17hw.repository.BookReactiveRepository;
import ru.otus.lesson17hw.repository.CommentReactiveRepository;
import ru.otus.lesson17hw.repository.GenreReactiveRepository;

import java.util.Random;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(Main.class, args);
        /*
        BookReactiveRepository bookRepository = context.getBean(BookReactiveRepository.class);
        AuthorReactiveRepository authorRepository = context.getBean(AuthorReactiveRepository.class);
        CommentReactiveRepository commentRepository = context.getBean(CommentReactiveRepository.class);
        GenreReactiveRepository genreRepository = context.getBean(GenreReactiveRepository.class);
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
            genre = genreRepository.save(genre).block();
            book.setGenre(genre);
            for(int valuesCount = 0; valuesCount < valuesLimit; valuesCount++){
                author = new Author();
                author.setFirstName("firstName: " + bookCount + ":" + valuesCount);
                author.setSecondName("secondName: " + bookCount + ":" + valuesCount);
                author = authorRepository.save(author).block();
                book.setAuthor(author);
                comment = new Comment();
                comment.setComment("comment: "  + bookCount + ":" + valuesCount);
                comment = commentRepository.save(comment).block();
                book.setComment(comment);
            }
            bookRepository.save(book);
        }
        //*/
    }
}
