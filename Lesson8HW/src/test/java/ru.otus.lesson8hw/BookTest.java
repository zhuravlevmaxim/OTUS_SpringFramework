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
import ru.otus.lesson8hw.entity.Book;
import ru.otus.lesson8hw.repository.book.BookRepositoryJdbc;

/**
 * Created by zhmv on 04.08.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.otus.lesson8hw")
public class BookTest {
    @Autowired
    private BookRepositoryJdbc bookRepositoryJdbc;

    @Test
    public void testCount(){
        Assert.assertEquals(bookRepositoryJdbc.count(), 1);
    }

    @Test
    public void testGetById(){
        Book bookTest = new Book();
        bookTest.setName("book1");
        bookTest.setDescription("description1");
        Assert.assertEquals(bookRepositoryJdbc.getById(1), bookTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(bookRepositoryJdbc.getAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        bookRepositoryJdbc.deleteById(1);
        Assert.assertEquals(bookRepositoryJdbc.count(), 0);
    }

    @Test
    public void testInsert(){
        Book bookTest = new Book();
        bookTest.setName("book2");
        bookTest.setDescription("description2");
        bookRepositoryJdbc.insert(bookTest);
        Assert.assertEquals(bookRepositoryJdbc.count(), 2);
    }
}
