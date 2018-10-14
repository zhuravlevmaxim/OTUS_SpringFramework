package ru.otus.lesson6hw.testauthor;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.otus.lesson6hw.dao.author.AuthorJDBCOperations;
import ru.otus.lesson6hw.dao.author.AuthorRowMapper;

import static org.mockito.Mockito.mock;

/**
 * Created by zhmv on 23.07.2018.
 */
@TestConfiguration
public class AuthorTestConfig {
    @Bean
    public AuthorRowMapper authorRowMapper(){
        return mock(AuthorRowMapper.class);
    }
    @Bean
    public AuthorJDBCOperations authorJDBCOperations(){
        return new AuthorJDBCOperations();
    }
}
