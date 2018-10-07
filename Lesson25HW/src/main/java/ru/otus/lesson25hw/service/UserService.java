package ru.otus.lesson25hw.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.lesson25hw.domain.User;

@MessagingGateway
public interface UserService {

    @Gateway(requestChannel = "userFlow.input")
    User userProcess(User user);
}
