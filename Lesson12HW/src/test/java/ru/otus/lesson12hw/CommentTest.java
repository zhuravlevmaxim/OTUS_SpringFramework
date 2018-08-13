package ru.otus.lesson12hw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson12hw.domain.Comment;
import ru.otus.lesson12hw.repository.CommentRepository;

/**
 * Created by zhmv on 12.08.2018.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class CommentTest {

    private static final String COMMENT = "comment";

    @Autowired
    private CommentRepository commentRepository;
    private Comment comment;

    @Before
    public void init(){
        comment = new Comment();
        comment.setComment(COMMENT);
        comment = commentRepository.save(comment);
    }

    @Test
    public void testComment(){
        Assert.assertTrue(COMMENT.equals(comment.getComment()));
    }

    @Test
    public void testCount(){
        System.out.println(commentRepository.findAll());
        Assert.assertTrue(commentRepository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        commentRepository.deleteAll();
        Assert.assertTrue(commentRepository.count() == 0);
    }
}
