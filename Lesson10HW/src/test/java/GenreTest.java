import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson10hw.Main;
import ru.otus.lesson10hw.repository.genre.GenreRepository;
import ru.otus.lesson10hw.entity.Genre;

/**
 * Created by zhmv on 04.08.2018.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes={Main.class})
@ComponentScan("ru.otus.lesson10hw")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.NONE)
public class GenreTest {
    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testCount(){
        Assert.assertEquals(genreRepository.count(), 1);
    }

    @Test
    public void testGetById(){
        Genre genreTest = new Genre();
        genreTest.setGenre("genre1");
        Assert.assertEquals(genreRepository.findById(1), genreTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(genreRepository.findAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        genreRepository.deleteById(1l);
        Assert.assertEquals(genreRepository.count(), 0);
    }

    @Test
    public void testInsert(){
        Genre genreTest = new Genre();
        genreTest.setGenre("genre2");
        genreRepository.save(genreTest);
        Assert.assertEquals(genreRepository.count(), 2);
    }
}
