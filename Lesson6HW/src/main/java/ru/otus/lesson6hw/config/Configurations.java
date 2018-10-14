package ru.otus.lesson6hw.config;

/**
 * Created by zhmv on 16.07.2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.otus.lesson6hw.dao.author.AuthorRowMapper;
import ru.otus.lesson6hw.dao.book.BookRowMapper;
import ru.otus.lesson6hw.dao.genre.GenreRowMapper;
import ru.otus.lesson6hw.services.*;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class Configurations {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceConfig.getDriverClassName());
        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUserName());
        dataSource.setPassword(dataSourceConfig.getPassword());
        Properties properties = new Properties();
        properties.setProperty(dataSourceConfig.getServerTimeZoneKey(), dataSourceConfig.getServerTimeZoneValue());
        dataSource.setConnectionProperties(properties);
        return dataSource;
    }
    @Bean
    public AuthorRowMapper authorRowMapper(){
        return new AuthorRowMapper();
    }
    @Bean
    public BookRowMapper bookRowMapper(){
        return new BookRowMapper();
    }
    @Bean
    public GenreRowMapper genreRowMapper(){
        return new GenreRowMapper();
    }
    @Bean
    public AuthorService authorService(){
        return new AuthorServiceImpl();
    }
    @Bean
    public BookService bookService(){
        return new BookServiceImpl();
    }
    @Bean
    public GenreService genreService(){
        return new GenreServiceImpl();
    }
}
