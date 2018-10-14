package ru.otus.lesson19hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson19hw.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findUserByUserName(String userName);
}
