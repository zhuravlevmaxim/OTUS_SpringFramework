package ru.otus.lesson5hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhmv on 11.07.2018.
 */
@Component
public class StartServiceImpl implements StartService {

    private Test test;

    @Autowired
    public StartServiceImpl(Test test){
        this.test = test;
    }

    public void start(String locale) {
        test.startTest(locale);
    }
}
