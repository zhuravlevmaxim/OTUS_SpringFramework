package ru.otus.lesson12hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson12hw.service.AuthorService;

/**
 * Created by zhmv on 12.08.2018.
 */
@ShellComponent
public class AuthorShell {

    @Autowired
    private AuthorService authorService;

    @ShellMethod("Author count")
    public long authorCount(){
        return  authorService.count();
    }
    @ShellMethod("Author get by id")
    public String authorGetById(@ShellOption String id){
        return authorService.getById(id).toString();
    }
    @ShellMethod("Author delete by id")
    public void authorDeleteById(@ShellOption String id){
        authorService.deleteById(id);
    }
    @ShellMethod("Author insert")
    public void authorInsert(@ShellOption String firstName, @ShellOption String secondName){
        authorService.insert(firstName, secondName);
    }
    @ShellMethod("Author list")
    public String authorList(){
        return  authorService.getAllAuthor().toString();
    }

}
