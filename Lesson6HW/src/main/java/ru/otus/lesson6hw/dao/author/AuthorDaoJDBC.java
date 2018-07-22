package ru.otus.lesson6hw.dao.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.lesson6hw.domain.Author;

import java.util.List;

/**
 * Created by zhmv on 16.07.2018.
 */
@Repository
public class AuthorDaoJDBC implements AuthorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AuthorRowMapper authorRowMapper;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from author", Integer.class);
    }

    @Override
    public Author getById(int id) {
        return jdbcTemplate.queryForObject("select * from author where id = ?", new Object[]{id}, authorRowMapper);
    }

    @Override
    public List<Author> getAllAuthor() {
        return jdbcTemplate.query("select * from author", authorRowMapper);
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from author where id = ?", id);
    }

    @Override
    public void insert(Author author) {
        jdbcTemplate.update("insert into author (id, firstName, secondName) values (?, ?, ?)",
                author.getId(),
                author.getFirstName(),
                author.getSecondName());
    }
}
