import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson10hw.Main;
import ru.otus.lesson10hw.repository.author.AuthorRepository;
import ru.otus.lesson10hw.entity.Author;

/**
 * Created by zhmv on 04.08.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes={Main.class})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan("ru.otus.lesson10hw")
public class AuthorTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testCount(){
        Assert.assertEquals(authorRepository.count(), 1);
    }

    @Test
    public void testGetById(){
        Author authorTest = new Author();
        authorTest.setFirstName("firstName");
        authorTest.setSecondName("secondName");
        Assert.assertEquals(authorRepository.findById(1), authorTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(authorRepository.findAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        authorRepository.deleteById(1l);
        Assert.assertEquals(authorRepository.count(), 0);
    }

    @Test
    public void testInsert(){
        Author authorTest = new Author();
        authorTest.setFirstName("firstName2");
        authorTest.setSecondName("secondName2");
        authorRepository.save(authorTest);
        Assert.assertEquals(authorRepository.count(), 2);
    }
}
