package ru.otus.lesson6hw.testgenre;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.otus.lesson6hw.dao.genre.GenreJDBCOperations;
import ru.otus.lesson6hw.dao.genre.GenreRowMapper;

import static org.mockito.Mockito.mock;

/**
 * Created by zhmv on 28.07.2018.
 */
@TestConfiguration
public class GenreTestConfig {
    @Bean
    public GenreRowMapper genreRowMapper(){
        return mock(GenreRowMapper.class);
    }
    @Bean
    public GenreJDBCOperations genreJDBCOperations(){
        return new GenreJDBCOperations();
    }
}
