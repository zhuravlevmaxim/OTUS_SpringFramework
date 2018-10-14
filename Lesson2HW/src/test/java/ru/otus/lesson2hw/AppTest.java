package ru.otus.lesson2hw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.lesson2hw.csv.CSVReaderImpl;

/**
 * Created by zhmv on 06.07.2018.
 */
public class AppTest {

    private AnnotationConfigApplicationContext context;
    private CSVReaderImpl csvReader;
    private ru.otus.lesson2hw.service.Test test;
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(TestConfig.class);
        csvReader = context.getBean(CSVReaderImpl.class);
        test = context.getBean(ru.otus.lesson2hw.service.Test.class);
    }

    @After
    public void destroy(){
        csvReader = null;
        context = null;
    }

    @Test
    public void testReader(){
        Assert.assertEquals(csvReader.getFilePathEN(), "/question/questionsENTest.csv");
        Assert.assertEquals(csvReader.getFilePathRU(), "/question/questionsRUTest.csv");
    }

    @Test
    public void testTestClass(){
        Assert.assertNotNull(test.getReader());
        Assert.assertNotNull(test.getMessageSource());
        Assert.assertEquals(test.getGoodPercent(), 1.1, 0);
    }
}
