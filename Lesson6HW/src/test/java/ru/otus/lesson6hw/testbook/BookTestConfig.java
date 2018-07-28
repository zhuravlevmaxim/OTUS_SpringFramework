package ru.otus.lesson6hw.testbook;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.otus.lesson6hw.dao.author.AuthorJDBCOperations;
import ru.otus.lesson6hw.dao.author.AuthorRowMapper;
import ru.otus.lesson6hw.dao.book.BookJDBCOperations;
import ru.otus.lesson6hw.dao.book.BookRowMapper;

import static org.mockito.Mockito.mock;

/**
 * Created by zhmv on 28.07.2018.
 */
@TestConfiguration
public class BookTestConfig {
    @Bean
    public BookRowMapper bookRowMapper(){
        return mock(BookRowMapper.class);
    }
    @Bean
    public BookJDBCOperations bookJDBCOperations(){
        return new BookJDBCOperations();
    }
}
