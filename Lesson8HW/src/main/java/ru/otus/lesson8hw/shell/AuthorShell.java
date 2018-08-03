package ru.otus.lesson8hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson8hw.services.AuthorService;

/**
 * Created by zhmv on 01.08.2018.
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
    public String authorGetById(@ShellOption long id){
        return authorService.getById(id).toString();
    }
    @ShellMethod("Author delete by id")
    public void authorDeleteById(@ShellOption long id){
        authorService.deleteById(id);
    }
    @ShellMethod("Author insert")
    public void authorInsert(@ShellOption long id, @ShellOption String firstName, @ShellOption String secondName){
        authorService.insert(firstName, secondName);
    }
    @ShellMethod("Author list")
    public String authorList(){
        return  authorService.getAllAuthor().toString();
    }

}
