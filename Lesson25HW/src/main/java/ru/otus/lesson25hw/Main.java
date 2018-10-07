package ru.otus.lesson25hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import ru.otus.lesson25hw.domain.User;
import ru.otus.lesson25hw.service.UserService;

@SpringBootApplication
@IntegrationComponentScan
@ComponentScan
@EnableIntegration
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
                context.getBean(UserService.class)
                .userProcess(new User("UserName", 25));
                context.close();
    }
}
