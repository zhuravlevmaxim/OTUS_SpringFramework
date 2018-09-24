package ru.otus.lesson21hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson21hw.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findUserByUserName(String userName);
}
