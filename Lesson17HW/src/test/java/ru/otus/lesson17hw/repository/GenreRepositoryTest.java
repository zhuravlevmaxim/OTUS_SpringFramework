package ru.otus.lesson17hw.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson17hw.domain.Genre;

@RunWith(SpringRunner.class)
@DataMongoTest
public class GenreRepositoryTest {
    private static final String GENRE = "genre";

    @Autowired
    private GenreReactiveRepository genreRepository;
    private Genre genre;

    @Before
    public void init(){
        genre = new Genre();
        genre.setGenre(GENRE);
        genreRepository.save(genre).block();
    }

    @After
    public void destroy(){
        genreRepository.deleteAll().block();
    }

    @Test
    public void testGenre(){
        Assert.assertTrue(GENRE.equals(genreRepository.findAll().blockFirst().getGenre()));
    }

    @Test
    public void testCount(){
        Assert.assertEquals(genreRepository.count().block().intValue(), 1);
    }

    @Test
    public void testDeleteAll(){
        genreRepository.deleteAll().block();
        Assert.assertEquals(genreRepository.count().block().intValue(),0);
    }
}
