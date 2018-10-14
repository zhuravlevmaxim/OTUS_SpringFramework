package ru.otus.lesson19hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson19hw.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
