package ru.otus.lesson6hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson6hw.services.AuthorService;

/**
 * Created by zhmv on 19.07.2018.
 */
@ShellComponent
public class AuthorShell {

    @Autowired
    private AuthorService authorService;

    @ShellMethod("Author count")
    public int authorCount(){
        return  authorService.count();
    }
    @ShellMethod("Author get by id")
    public String authorGetById(@ShellOption int id){
        return authorService.getById(id).toString();
    }
    @ShellMethod("Author delete by id")
    public void authorDeleteById(@ShellOption int id){
        authorService.deleteById(id);
    }
    @ShellMethod("Author insert")
    public void authorInsert(@ShellOption int id, @ShellOption String firstName, @ShellOption String secondName){
        authorService.insert(id, firstName, secondName);
    }
    @ShellMethod("Author list")
    public String authorList(){
        return  authorService.getAllAuthor().toString();
    }
}
