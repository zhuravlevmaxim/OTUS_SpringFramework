package ru.otus.lesson6hw.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ru.otus.lesson6hw.dao.author.AuthorJDBCOperations;
import ru.otus.lesson6hw.dao.genre.GenreJDBCOperations;
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
    private AuthorJDBCOperations authorJDBCOperations;
    @Autowired
    private GenreJDBCOperations genreJDBCOperations;

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Author author = authorJDBCOperations.getById(resultSet.getInt("id_author"));
        Genre genre = genreJDBCOperations.getById(resultSet.getInt("id_genre"));
        return new Book(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                author, genre);
    }
}
