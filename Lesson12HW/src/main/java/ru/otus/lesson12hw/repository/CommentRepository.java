package ru.otus.lesson12hw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.lesson12hw.domain.Comment;

/**
 * Created by zhmv on 12.08.2018.
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
