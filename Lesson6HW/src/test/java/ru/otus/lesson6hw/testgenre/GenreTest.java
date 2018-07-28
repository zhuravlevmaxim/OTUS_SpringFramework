package ru.otus.lesson6hw.testgenre;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson6hw.dao.genre.GenreJDBCOperations;
import ru.otus.lesson6hw.dao.genre.GenreRowMapper;
import ru.otus.lesson6hw.domain.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by zhmv on 22.07.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GenreTestConfig.class,properties={
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class GenreTest {
    @Autowired
    GenreJDBCOperations genreJDBCOperations;
    @Autowired
    GenreRowMapper genreRowMapper;
    @MockBean
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Test
    public void testCount() {
        final Map<String, Object> params = new HashMap<>(1);
        String query = "select count(*) from genre";
        when(namedJdbcTemplate.queryForObject(query, params, Integer.class)).thenReturn(1);
        Assert.assertEquals(genreJDBCOperations.count(), 1);
    }

    @Test
    public void testGetById(){
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", 1);
        String query = "select * from genre where id = :id";
        when(namedJdbcTemplate.queryForObject(query, params, genreRowMapper))
                .thenReturn(new Genre(1, "genre1"));
        Assert.assertNotNull(genreJDBCOperations.getById(1));
        Assert.assertEquals(genreJDBCOperations.getById(1).getId(), 1);
        Assert.assertEquals(genreJDBCOperations.getById(1).getGenreName(), "genre1");
    }

    @Test
    public void testGetAllGenre() {
        String query = "select * from genre";
        when(namedJdbcTemplate.query(query, genreRowMapper)).thenReturn(new ArrayList<Genre>());
        Assert.assertEquals(genreJDBCOperations.getAllGenre(), new ArrayList<Genre>());
    }
}
