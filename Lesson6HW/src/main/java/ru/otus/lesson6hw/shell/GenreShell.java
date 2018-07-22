package ru.otus.lesson6hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson6hw.services.GenreService;

/**
 * Created by zhmv on 19.07.2018.
 */
@ShellComponent
public class GenreShell {
    @Autowired
    private GenreService genreService;
    @ShellMethod("Genre count")
    public int genreCount(){
        return  genreService.count();
    }
    @ShellMethod("Genre get by id")
    public String genreGetById(@ShellOption int id){
        return genreService.getById(id).toString();
    }
    @ShellMethod("Genre delete by id")
    public void genreDeleteById(@ShellOption int id){
        genreService.deleteById(id);
    }
    @ShellMethod("Genre insert")
    public void genreInsert(@ShellOption int id, @ShellOption String genreName){
        genreService.insert(id, genreName);
    }
    @ShellMethod("Genre list")
    public String genreList(){
        return  genreService.getAllGenre().toString();
    }
}
