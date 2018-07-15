package ru.otus.lesson5hw.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.lesson5hw.service.StartService;

/**
 * Created by zhmv on 11.07.2018.
 */
@ShellComponent
public class StartCommands {
    private final StartService startService;

    @Autowired
    public StartCommands(StartService startService){
        this.startService = startService;
    }
    @ShellMethod("Send locale")
    public void start(@ShellOption String locale){
        startService.start(locale);
    }
}
