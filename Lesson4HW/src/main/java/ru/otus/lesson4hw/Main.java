package ru.otus.lesson4hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.lesson4hw.service.Test;

/**
 * Created by zhmv on 09.07.2018.
 */

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        Test test = context.getBean(Test.class);
        test.startTest();
    }
}
