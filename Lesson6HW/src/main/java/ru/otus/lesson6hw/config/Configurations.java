package ru.otus.lesson6hw.config;

/**
 * Created by zhmv on 16.07.2018.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.otus.lesson6hw.dao.author.AuthorRowMapper;
import ru.otus.lesson6hw.dao.book.BookRowMapper;
import ru.otus.lesson6hw.dao.genre.GenreRowMapper;
import ru.otus.lesson6hw.services.*;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ConfigurationProperties("dbconfig")
public class Configurations {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
    private String serverTimeZoneKey;
    private String serverTimeZoneValue;
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//        Properties properties = new Properties();
//        properties.setProperty(serverTimeZoneKey, serverTimeZoneValue);

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/otus6");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Properties properties = new Properties();
        properties.setProperty("serverTimezone", "UTC");

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
