package ru.otus.lesson29hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson29hw.domain.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUserName(String userName);

    List<User> deleteUserByUserName(String userName);
}
