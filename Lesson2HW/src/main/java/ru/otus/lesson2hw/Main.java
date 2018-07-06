package ru.otus.lesson2hw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.lesson2hw.service.Test;

/**
 * Created by zhmv on 02.07.2018.
 */
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Test test = context.getBean(Test.class);
        test.startTest();
    }
}
