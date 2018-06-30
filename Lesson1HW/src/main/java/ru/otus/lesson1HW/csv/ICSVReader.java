package ru.otus.lesson1HW.csv;

import ru.otus.lesson1HW.service.Question;

import java.util.List;

/**
 * Created by zhmv on 30.06.2018.
 */
public interface ICSVReader {

    public List<Question> getQuestions();
}
