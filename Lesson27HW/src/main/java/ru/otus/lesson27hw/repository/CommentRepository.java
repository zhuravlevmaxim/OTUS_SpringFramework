package ru.otus.lesson27hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson27hw.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
