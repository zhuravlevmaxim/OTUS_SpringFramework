package lesson4hw;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.lesson4hw.csv.CSVReaderImpl;

/**
 * Created by zhmv on 06.07.2018.
 */
public class AppTest {

    private AnnotationConfigApplicationContext context;
    private CSVReaderImpl csvReader;
    private ru.otus.lesson4hw.service.Test test;
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(TestConfig.class);
        csvReader = context.getBean(CSVReaderImpl.class);
        test = context.getBean(ru.otus.lesson4hw.service.Test.class);
    }

    @After
    public void destroy(){
        csvReader = null;
        context = null;
    }
    @Ignore
    @Test
    public void testReader(){
        //Assert.assertEquals(csvReader.getFilePathEN(), "/question/questionsENTest.csv");
        //Assert.assertEquals(csvReader.getFilePathRU(), "/question/questionsRUTest.csv");
    }

    @Ignore
    @Test
    public void testTestClass(){
        Assert.assertNotNull(test.getReader());
        Assert.assertNotNull(test.getMessageSource());
        Assert.assertEquals(test.getGoodPercent(), 1.1, 0);
    }
}
