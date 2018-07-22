package ru.otus.lesson6hw;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by zhmv on 22.07.2018.
 */
@Configuration
public class Config {

    public DataSource dataSource(){
        DriverManagerDataSource result = new DriverManagerDataSource();
        result.setDriverClassName("org.h2.Driver");
        result.setUrl("jdbc:h2:file:");
        result.setUsername("sa");
        result.setPassword("");
        return result;
    }
}
