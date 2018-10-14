package ru.otus.lesson6hw.dao.author;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.lesson6hw.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhmv on 16.07.2018.
 */
public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Author(resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("secondName"));
    }
}
