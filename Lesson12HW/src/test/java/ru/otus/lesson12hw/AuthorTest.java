package ru.otus.lesson12hw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson12hw.domain.Author;
import ru.otus.lesson12hw.repository.AuthorRepository;

/**
 * Created by zhmv on 12.08.2018.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class AuthorTest {

    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";

    @Autowired
    private AuthorRepository authorRepository;
    private Author author;

    @Before
    public void init(){
        author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setSecondName(SECOND_NAME);
        author = authorRepository.save(author);
    }

    @Test
    public void testAuthorNames(){
        Assert.assertTrue(FIRST_NAME.equals(author.getFirstName()));
        Assert.assertTrue(SECOND_NAME.equals(author.getSecondName()));
    }

    @Test
    public void testCount(){
        System.out.println(authorRepository.findAll());
        Assert.assertTrue(authorRepository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        authorRepository.deleteAll();
        Assert.assertTrue(authorRepository.count() == 0);
    }
}
