package ru.otus.lesson5hw;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson5hw.csv.CSVReaderImpl;

/**
 * Created by zhmv on 06.07.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties={
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
        })
public class AppTest {

    @Autowired
    private CSVReaderImpl reader;

    @Autowired
    private ru.otus.lesson5hw.service.Test test;

    @Test
    public void testReader(){
        Assert.assertEquals(reader.getCsvReaderConfig().getFilesPath(), "RU:/question/questionsRU.csv,EN:/question/questionsEN.csv");
    }

    @Test
    public void testTestClass(){
        Assert.assertNotNull(test.getReader());
        Assert.assertNotNull(test.getMessageSource());
        Assert.assertEquals(test.getGoodPercent(), 0.7, 0);
    }
}