package ru.otus.lesson6hw.dao.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.lesson6hw.domain.Genre;

import java.util.List;

/**
 * Created by zhmv on 16.07.2018.
 */
@Repository
public class GenreDaoJDBC implements GenreDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GenreRowMapper genreRowMapper;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from genre", Integer.class);
    }

    @Override
    public Genre getById(int id) {
        return jdbcTemplate.queryForObject("select * from genre where id = ?", new Object[]{id}, genreRowMapper);
    }

    @Override
    public List<Genre> getAllGenre() {
        return jdbcTemplate.query("select * from genre", genreRowMapper);
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from genre where id = ?", id);
    }

    @Override
    public void insert(Genre genre) {
        jdbcTemplate.update("insert into genre (id, genreName) values (?, ?)",
                genre.getId(),
                genre.getGenreName());
    }
}
