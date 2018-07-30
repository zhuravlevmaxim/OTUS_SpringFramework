package ru.otus.lesson8hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zhmv on 30.07.2018.
 */
@Configuration
public class Config {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hibernate.dialect.MySQLDialect");
        dataSource.setUrl("jdbc:mysql://localhost:3306/otus8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Properties properties = new Properties();
        properties.setProperty("serverTimezone", "UTC");
        dataSource.setConnectionProperties(properties);
        return dataSource;
    }
}
