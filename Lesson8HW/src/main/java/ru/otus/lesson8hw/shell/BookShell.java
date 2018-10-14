package ru.otus.lesson8hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson8hw.services.BookService;

/**
 * Created by zhmv on 01.08.2018.
 */
@ShellComponent
public class BookShell {

    @Autowired
    private BookService bookService;

    @ShellMethod("Book count")
    public long bookCount(){
        return  bookService.count();
    }
    @ShellMethod("Book get by id")
    public String bookGetById(@ShellOption long id){
        return bookService.getById(id).toString();
    }
    @ShellMethod("Book delete by id")
    public void bookDeleteById(@ShellOption long id){
        bookService.deleteById(id);
    }
    @ShellMethod("Book insert")
    public void bookInsert(@ShellOption String name, @ShellOption String description, @ShellOption String firstName,
                           @ShellOption String secondName, @ShellOption String genreName, @ShellOption String comment){
        bookService.insert(name, description, firstName, secondName, genreName, comment);
    }
    @ShellMethod("Book list")
    public String bookList(){
        return  bookService.getAllBook().toString();
    }
}
