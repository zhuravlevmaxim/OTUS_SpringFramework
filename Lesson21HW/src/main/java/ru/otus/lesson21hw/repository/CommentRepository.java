package ru.otus.lesson21hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson21hw.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
