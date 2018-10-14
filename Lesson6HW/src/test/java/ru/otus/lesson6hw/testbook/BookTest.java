package ru.otus.lesson6hw.testbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson6hw.dao.book.BookJDBCOperations;
import ru.otus.lesson6hw.dao.book.BookRowMapper;
import ru.otus.lesson6hw.domain.Author;
import ru.otus.lesson6hw.domain.Book;
import ru.otus.lesson6hw.domain.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by zhmv on 22.07.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookTestConfig.class,properties={
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class BookTest {
    @Autowired
    BookJDBCOperations bookJDBCOperations;
    @Autowired
    BookRowMapper bookRowMapper;
    @MockBean
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Test
    public void testAuthorCount() {
        final Map<String, Object> params = new HashMap<>(1);
        String query = "select count(*) from book";
        when(namedJdbcTemplate.queryForObject(query, params, Integer.class)).thenReturn(1);
        Assert.assertEquals(bookJDBCOperations.count(), 1);
    }

    @Test
    public void testGetById(){
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", 1);
        String query = "select * from book where id = :id";
        when(namedJdbcTemplate.queryForObject(query, params, bookRowMapper))
                .thenReturn(new Book(1, "nameBook", "description",
                        new Author(1, "name1", "name2"),
                        new Genre(1, "genre1")));
        Assert.assertNotNull(bookJDBCOperations.getById(1));
    }

    @Test
    public void testGetAllBook() {
        String query = "select * from book";
        when(namedJdbcTemplate.query(query, bookRowMapper)).thenReturn(new ArrayList<Book>());
        Assert.assertEquals(bookJDBCOperations.getAllBook(), new ArrayList<Book>());
    }
}
