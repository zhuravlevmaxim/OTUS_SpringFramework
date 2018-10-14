package ru.otus.lesson6hw.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.lesson6hw.dao.author.AuthorJDBCOperations;
import ru.otus.lesson6hw.dao.genre.GenreJDBCOperations;
import ru.otus.lesson6hw.domain.Author;
import ru.otus.lesson6hw.domain.Book;
import ru.otus.lesson6hw.domain.Genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhmv on 16.07.2018.
 */
@Repository
public class BookJDBCOperations implements BookDao{
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    @Autowired
    private GenreJDBCOperations genreJDBCOperations;
    @Autowired
    private AuthorJDBCOperations authorJDBCOperations;
    @Autowired
    private BookRowMapper bookRowMapper;

    @Override
    public int count()
    {
        String query = "select count(*) from book";
        final Map<String, Object> params = new HashMap<>(1);
        return namedJdbcTemplate.queryForObject(query, params,Integer.class);
    }

    @Override
    public Book getById(int id) {
        String query = "select * from book where id = :id";
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return namedJdbcTemplate.queryForObject(query, params, bookRowMapper);
    }

    @Override
    public List<Book> getAllBook() {
        String query = "select * from book";
        return namedJdbcTemplate.query(query, bookRowMapper);
    }

    @Override
    public void insert(Book book) {
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        String query = "insert into book (id, name, description, id_author, id_genre) " +
                "values(:id, :name, :description, :id_author, :id_genre)";
        final Map<String, Object> params = new HashMap<>(5);
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("description", book.getDescription());
        params.put("id_author", book.getId_author());
        params.put("id_genre", book.getId_genre());
        namedJdbcTemplate.update(query, params);
        authorJDBCOperations.insert(author);
        genreJDBCOperations.insert(genre);
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from book where id = :id";
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        namedJdbcTemplate.update(query, params);
    }
}
