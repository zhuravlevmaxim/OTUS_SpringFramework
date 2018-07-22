package ru.otus.lesson6hw.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ru.otus.lesson6hw.dao.author.AuthorDaoJDBC;
import ru.otus.lesson6hw.dao.genre.GenreDaoJDBC;
import ru.otus.lesson6hw.domain.Author;
import ru.otus.lesson6hw.domain.Book;
import ru.otus.lesson6hw.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhmv on 17.07.2018.
 */
public class BookRowMapper implements RowMapper<Book> {
    @Autowired
    private AuthorDaoJDBC authorDaoJDBC;
    @Autowired
    private GenreDaoJDBC genreDaoJDBC;

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Author author = authorDaoJDBC.getById(resultSet.getInt("id_author"));
        Genre genre = genreDaoJDBC.getById(resultSet.getInt("id_genre"));
        return new Book(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                author, genre);
    }
}
