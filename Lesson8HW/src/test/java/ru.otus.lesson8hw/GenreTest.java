package ru.otus.lesson8hw;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson8hw.entity.Genre;
import ru.otus.lesson8hw.repository.genre.GenreRepositoryJdbc;

/**
 * Created by zhmv on 04.08.2018.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.otus.lesson8hw")
public class GenreTest {
    @Autowired
    private GenreRepositoryJdbc genreRepositoryJdbc;

    @Test
    public void testCount(){
        Assert.assertEquals(genreRepositoryJdbc.count(), 1);
    }

    @Test
    public void testGetById(){
        Genre genreTest = new Genre();
        genreTest.setGenre("genre1");
        Assert.assertEquals(genreRepositoryJdbc.getById(1), genreTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(genreRepositoryJdbc.getAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        genreRepositoryJdbc.deleteById(1);
        Assert.assertEquals(genreRepositoryJdbc.count(), 0);
    }

    @Test
    public void testInsert(){
        Genre genreTest = new Genre();
        genreTest.setGenre("genre2");
        genreRepositoryJdbc.insert(genreTest);
        Assert.assertEquals(genreRepositoryJdbc.count(), 2);
    }
}
