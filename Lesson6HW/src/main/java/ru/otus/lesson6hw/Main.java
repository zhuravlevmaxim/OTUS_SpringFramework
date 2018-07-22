package ru.otus.lesson6hw;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.lesson6hw.dao.author.AuthorDaoJDBC;
import ru.otus.lesson6hw.dao.book.BookDaoJDBC;
import ru.otus.lesson6hw.domain.Author;
import ru.otus.lesson6hw.domain.Book;
import ru.otus.lesson6hw.domain.Genre;

import java.sql.SQLException;


/**
 * Created by zhmv on 16.07.2018.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class);

        //AuthorDaoJDBC authorDaoJDBC = context.getBean(AuthorDaoJDBC.class);
        //System.out.println(authorDaoJDBC.count());

        //BookDaoJDBC bookDaoJDBC = context.getBean(BookDaoJDBC.class);

        //authorDaoJDBC.insert(new Author(2, "name2", "second2"));

        //System.out.println(authorDaoJDBC.getAllAuthor());

        //authorDaoJDBC.deleteById(1);

        //System.out.println(authorDaoJDBC.getAllAuthor());

        //Author author = new Author(100,"Name100", "200");
        //Genre genre = new Genre(200, "Genre: 200");
        //Book book = new Book(300, "Book: 300", "Book: 300", author, genre);

        //bookDaoJDBC.insert(book);

        //System.out.println(bookDaoJDBC.count());

        //System.out.println(bookDaoJDBC.getAllBook());

        //Console.main(args);
    }

}
