package ru.otus.lesson4hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.lesson4hw.service.Test;

/**
 * Created by zhmv on 09.07.2018.
 */

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Test test = context.getBean(Test.class);
        test.startTest();
    }
}
