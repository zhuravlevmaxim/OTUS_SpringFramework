package ru.otus.lesson21hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/mylogin")
    public String login(){
        return "mylogin";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
