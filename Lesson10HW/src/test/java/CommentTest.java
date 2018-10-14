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
import ru.otus.lesson10hw.repository.comment.CommentRepository;
import ru.otus.lesson10hw.entity.Comment;

/**
 * Created by zhmv on 04.08.2018.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes={Main.class})
@ComponentScan("ru.otus.lesson10hw")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testCount(){
        Assert.assertEquals(commentRepository.count(), 1);
    }

    @Test
    public void testGetById(){
        Comment commentTest = new Comment();
        commentTest.setComment("comment1");
        Assert.assertEquals(commentRepository.findById(1), commentTest);
    }

    @Test
    public void testGetAll(){
        Assert.assertEquals(commentRepository.findAll().size(), 1);
    }

    @Test
    public void testDeleteById(){
        commentRepository.deleteById(1l);
        Assert.assertEquals(commentRepository.count(), 0);
    }

    @Test
    public void testInsert(){
        Comment commentTest = new Comment();
        commentTest.setComment("comment2");
        commentRepository.save(commentTest);
        Assert.assertEquals(commentRepository.count(), 2);
    }
}
