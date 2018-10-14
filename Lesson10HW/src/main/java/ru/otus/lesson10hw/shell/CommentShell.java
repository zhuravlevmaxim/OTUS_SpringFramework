package ru.otus.lesson10hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson10hw.services.CommentService;

/**
 * Created by zhmv on 01.08.2018.
 */
@ShellComponent
public class CommentShell {

    @Autowired
    private CommentService commentService;

    @ShellMethod("Comment count")
    public long commentCount(){
        return  commentService.count();
    }
    @ShellMethod("Comment get by id")
    public String commentGetById(@ShellOption long id){
        return commentService.getById(id).toString();
    }
    @ShellMethod("Comment delete by id")
    public void commentDeleteById(@ShellOption long id){
        commentService.deleteById(id);
    }
    @ShellMethod("Comment insert")
    public void commentInsert(@ShellOption long idBook, @ShellOption String comment){
        commentService.insert(idBook, comment);
    }
    @ShellMethod("Comment list")
    public String commentList(){
        return  commentService.getAllComment().toString();
    }

}
