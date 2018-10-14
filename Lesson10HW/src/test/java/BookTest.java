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
import ru.otus.lesson10hw.repository.book.BookRepository;
import ru.otus.lesson10hw.entity.Book;

/**
 * Created by zhmv on 04.08.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes={Main.class})
@ComponentScan("ru.otus.lesson10hw")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCount(){
        Assert.assertEquals(bookRepository.count(), 1);
    }

    @Test
    public void testGetById(){
        Book bookTest = new Book();
        bookTest.setName("book1");
        bookTest.setDescription("description1");
        Assert.assertEquals(bookRepository.findById(1), bookTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(bookRepository.findAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        bookRepository.deleteById(1l);
        Assert.assertEquals(bookRepository.count(), 0);
    }

    @Test
    public void testInsert(){
        Book bookTest = new Book();
        bookTest.setName("book2");
        bookTest.setDescription("description2");
        bookRepository.save(bookTest);
        Assert.assertEquals(bookRepository.count(), 2);
    }
}
