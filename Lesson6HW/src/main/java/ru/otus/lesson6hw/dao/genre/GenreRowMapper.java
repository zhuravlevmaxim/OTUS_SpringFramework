package ru.otus.lesson6hw.dao.genre;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.lesson6hw.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhmv on 17.07.2018.
 */
public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Genre(resultSet.getInt("id"), resultSet.getString("genreName"));
    }
}
