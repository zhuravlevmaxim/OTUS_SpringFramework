package ru.otus.lesson29hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson29hw.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
