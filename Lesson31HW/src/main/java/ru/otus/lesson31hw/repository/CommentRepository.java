package ru.otus.lesson31hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson31hw.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
