package ru.otus.lesson15hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson15hw.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
