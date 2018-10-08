package ru.otus.lesson21hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import ru.otus.lesson21hw.domain.*;
import ru.otus.lesson21hw.repository.*;

import java.util.Random;

@SpringBootApplication
@EnableGlobalAuthentication
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
        /*
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User();
        user.setUserName("userName");
        user.setPassword("userPassword");
        user.setRole("USER");
        userRepository.save(user);
        System.out.println(userRepository.findUserByUserName("userName").getPassword());
        //*/
    }
}
