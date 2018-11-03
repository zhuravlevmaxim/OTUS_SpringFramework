package ru.otus.lesson31hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson31hw.domain.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUserName(String userName);

    List<User> deleteUserByUserName(String userName);
}
