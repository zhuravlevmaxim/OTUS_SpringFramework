package ru.otus.lesson6hw.dao.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.lesson6hw.domain.Genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhmv on 16.07.2018.
 */
@Repository
public class GenreJDBCOperations implements GenreDao {
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    @Autowired
    private GenreRowMapper genreRowMapper;

    @Override
    public int count() {
        String query = "select count(*) from genre";
        final Map<String, Object> params = new HashMap<>(1);
        return namedJdbcTemplate.queryForObject(query, params, Integer.class);
    }

    @Override
    public Genre getById(int id) {
        String query = "select * from genre where id = :id";
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return namedJdbcTemplate.queryForObject(query, params, genreRowMapper);
    }

    @Override
    public List<Genre> getAllGenre() {
        String query = "select * from genre";
        return namedJdbcTemplate.query(query, genreRowMapper);
    }

    @Override
    public void deleteById(int id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        String query = "delete from genre where id = :id";
        namedJdbcTemplate.update(query, params);
    }

    @Override
    public void insert(Genre genre) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", genre.getId());
        params.put("genreName", genre.getGenreName());
        String query = "insert into genre (id, genreName) values (:id, :genreName)";
        namedJdbcTemplate.update(query, params);
    }
}
