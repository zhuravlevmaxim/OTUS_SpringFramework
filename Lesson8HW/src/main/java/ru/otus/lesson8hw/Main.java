package ru.otus.lesson8hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.lesson8hw.entity.Author;
import ru.otus.lesson8hw.repository.author.AuthorRepositoryJdbc;

/**
 * Created by zhmv on 29.07.2018.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        //applicationContext.getBean(AuthorRepositoryJdbc.class).insert(new Author("firstName", "secondName"));
    }
}
