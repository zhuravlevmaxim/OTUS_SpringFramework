package ru.otus.lesson17hw.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson17hw.domain.Author;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AuthorRepositoryTest {

    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";

    @Autowired
    private AuthorReactiveRepository authorRepository;
    private Author author;

    @Before
    public void init(){
        author = new Author(FIRST_NAME, SECOND_NAME);
        authorRepository.save(author).then().block();
    }

    @After
    public void destroy(){
        authorRepository.deleteAll().then().block();
    }

    @Test
    public void testNames(){
        author = authorRepository.findAll().blockFirst();
        Assert.assertTrue(FIRST_NAME.equals(author.getFirstName()));
        Assert.assertTrue(SECOND_NAME.equals(author.getSecondName()));
    }

    @Test
    public void testCount(){
        Assert.assertEquals(authorRepository.count().block().intValue(), 1);
    }

    @Test
    public void testDeleteAll(){
        authorRepository.deleteAll().block();
        Assert.assertEquals(authorRepository.count().block().intValue(), 0);
    }
}
