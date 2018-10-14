package ru.otus.lesson12hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.lesson12hw.domain.Author;
import ru.otus.lesson12hw.domain.Book;
import ru.otus.lesson12hw.domain.Comment;
import ru.otus.lesson12hw.domain.Genre;
import ru.otus.lesson12hw.repository.AuthorRepository;
import ru.otus.lesson12hw.repository.BookRepository;
import ru.otus.lesson12hw.repository.CommentRepository;
import ru.otus.lesson12hw.repository.GenreRepository;

/**
 * Created by zhmv on 12.08.2018.
 */
@SpringBootApplication
@EnableMongoRepositories("ru.otus.lesson12hw.repository")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
