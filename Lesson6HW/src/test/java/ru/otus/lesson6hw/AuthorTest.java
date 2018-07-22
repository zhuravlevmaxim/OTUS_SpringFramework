package ru.otus.lesson6hw;

import org.h2.tools.Console;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson6hw.dao.author.AuthorDaoJDBC;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zhmv on 22.07.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties={
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@Import(Config.class)
public class AuthorTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AuthorDaoJDBC authorDaoJDBC;

    @Test
    public void testAuthor() throws SQLException {
        Console.main(new String[]{});
        Assert.assertTrue(authorDaoJDBC.count() > -1);
    }

}
