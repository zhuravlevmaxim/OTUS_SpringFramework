package ru.otus.lesson8hw;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson8hw.entity.Author;
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.repository.author.AuthorRepositoryJdbc;

/**
 * Created by zhmv on 04.08.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.otus.lesson8hw")
public class AuthorTest {

    @Autowired
    private AuthorRepositoryJdbc authorRepositoryJdbc;

    @Test
    public void testCount(){
        Assert.assertEquals(authorRepositoryJdbc.count(), 1);
    }

    @Test
    public void testGetById(){
        Author authorTest = new Author();
        authorTest.setFirstName("firstName");
        authorTest.setSecondName("secondName");
        Assert.assertEquals(authorRepositoryJdbc.getById(1), authorTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(authorRepositoryJdbc.getAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        authorRepositoryJdbc.deleteById(1);
        Assert.assertEquals(authorRepositoryJdbc.count(), 0);
    }

    @Ignore
    @Test
    public void testInsert(){
        Author authorTest = new Author();
        authorTest.setFirstName("firstName2");
        authorTest.setSecondName("secondName2");
        authorRepositoryJdbc.insert(authorTest);
        Assert.assertEquals(authorRepositoryJdbc.count(), 1);
    }
}
