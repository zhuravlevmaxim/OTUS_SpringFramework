package ru.otus.lesson17hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.lesson17hw.domain.Comment;

public interface CommentReactiveRepository extends ReactiveMongoRepository<Comment, String> {
}
