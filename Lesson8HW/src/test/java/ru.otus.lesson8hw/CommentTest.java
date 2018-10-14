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
import ru.otus.lesson8hw.entity.Comment;
import ru.otus.lesson8hw.repository.comment.CommentRepositoryJdbc;

/**
 * Created by zhmv on 04.08.2018.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.otus.lesson8hw")
public class CommentTest {
    @Autowired
    private CommentRepositoryJdbc commentRepositoryJdbc;

    @Test
    public void testCount(){
        Assert.assertEquals(commentRepositoryJdbc.count(), 1);
    }

    @Test
    public void testGetById(){
        Comment commentTest = new Comment();
        commentTest.setComment("comment1");
        Assert.assertEquals(commentRepositoryJdbc.getById(1), commentTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(commentRepositoryJdbc.getAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        commentRepositoryJdbc.deleteById(1);
        Assert.assertEquals(commentRepositoryJdbc.count(), 0);
    }

    @Test
    public void testInsert(){
        Comment commentTest = new Comment();
        commentTest.setComment("comment2");
        commentRepositoryJdbc.insert(commentTest);
        Assert.assertEquals(commentRepositoryJdbc.count(), 2);
    }
}
