package ru.otus.lesson1HW;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.lesson1HW.service.Test;

/**
 * Created by zhmv on 30.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Test test = context.getBean(Test.class);
        test.startTest();
    }
}
