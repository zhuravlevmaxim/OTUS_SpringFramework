package ru.otus.lesson17hw.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.lesson17hw.domain.Comment;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CommentRepositoryTest {

    private static final String COMMENT = "comment";

    @Autowired
    private CommentReactiveRepository commentRepository;
    private Comment comment;

    @Before
    public void init(){
        comment = new Comment();
        comment.setComment(COMMENT);
        commentRepository.save(comment).block();
    }

    @After
    public void destroy(){
        commentRepository.deleteAll().block();
    }

    @Test
    public void testComment(){
        Assert.assertTrue(COMMENT.equals(commentRepository.findAll().blockFirst().getComment()));
    }

    @Test
    public void testCount(){
        Assert.assertEquals(commentRepository.count().block().intValue(), 1);
    }

    @Test
    public void testDeleteAll(){
        commentRepository.deleteAll().block();
        Assert.assertEquals(commentRepository.count().block().intValue(),0);
    }
}
