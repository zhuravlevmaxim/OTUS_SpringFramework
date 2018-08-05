package ru.otus.lesson10hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson10hw.services.GenreService;

/**
 * Created by zhmv on 01.08.2018.
 */
@ShellComponent
public class GenreShell {

    @Autowired
    private GenreService genreService;

    @ShellMethod("Genre count")
    public long genreCount(){
        return  genreService.count();
    }
    @ShellMethod("Genre get by id")
    public String genreGetById(@ShellOption long id){
        return genreService.getById(id).toString();
    }
    @ShellMethod("Genre delete by id")
    public void genreDeleteById(@ShellOption long id){
        genreService.deleteById(id);
    }
    @ShellMethod("Genre insert")
    public void genreInsert(@ShellOption long idBook, @ShellOption String genre){
        genreService.insert(idBook, genre);
    }
    @ShellMethod("Genre list")
    public String genreList(){
        return  genreService.getAllGenre().toString();
    }
}
