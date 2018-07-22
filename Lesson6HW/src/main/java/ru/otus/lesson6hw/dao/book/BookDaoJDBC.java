package ru.otus.lesson6hw.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.lesson6hw.dao.author.AuthorDaoJDBC;
import ru.otus.lesson6hw.dao.genre.GenreDaoJDBC;
import ru.otus.lesson6hw.domain.Author;
import ru.otus.lesson6hw.domain.Book;
import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 16.07.2018.
 */
@Repository
public class BookDaoJDBC implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GenreDaoJDBC genreDaoJDBC;
    @Autowired
    private AuthorDaoJDBC authorDaoJDBC;
    @Autowired
    private BookRowMapper bookRowMapper;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*)", Integer.class);
    }

    @Override
    public Book getById(int id) {
        String query = "select * from book where id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, bookRowMapper);
    }

    @Override
    public List<Book> getAllBook() {
        return jdbcTemplate.query("select * from book", bookRowMapper);
    }

    @Override
    public void insert(Book book) {
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        jdbcTemplate.update("insert into book (id, name, description, id_author, id_genre) values(?, ?, ?, ?, ?)",
                book.getId(), book.getName(), book.getDescription(), author.getId(), genre.getId());
        authorDaoJDBC.insert(author);
        genreDaoJDBC.insert(genre);
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from book where id = ?", id);
    }
}
