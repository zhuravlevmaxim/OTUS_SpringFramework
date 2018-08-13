package ru.otus.lesson12hw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson12hw.domain.Genre;
import ru.otus.lesson12hw.repository.GenreRepository;

/**
 * Created by zhmv on 12.08.2018.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class GenreTest {

    private static final String GENRE = "genre";

    @Autowired
    private GenreRepository genreRepository;
    private Genre genre;

    @Before
    public void init(){
        genre = new Genre();
        genre.setGenre(GENRE);
        genre = genreRepository.save(genre);
    }

    @Test
    public void testGenre(){
        Assert.assertTrue(GENRE.equals(genre.getGenre()));
    }

    @Test
    public void testCount(){
        System.out.println(genreRepository.findAll());
        Assert.assertTrue(genreRepository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        genreRepository.deleteAll();
        Assert.assertTrue(genreRepository.count() == 0);
    }
}
