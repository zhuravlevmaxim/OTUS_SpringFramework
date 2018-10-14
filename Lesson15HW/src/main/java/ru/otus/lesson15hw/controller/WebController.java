package ru.otus.lesson15hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "index";
    }

}
