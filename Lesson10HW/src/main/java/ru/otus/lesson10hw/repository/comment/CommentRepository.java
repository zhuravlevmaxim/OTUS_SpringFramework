package ru.otus.lesson10hw.repository.comment;

import org.springframework.data.repository.CrudRepository;
import ru.otus.lesson10hw.entity.Comment;

import java.util.List;

/**
 * Created by zhmv on 05.08.2018.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public Comment  findById(long id);

    public List<Comment> findAll();
}
