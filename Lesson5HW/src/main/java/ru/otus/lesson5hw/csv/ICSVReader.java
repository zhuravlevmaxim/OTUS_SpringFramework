package ru.otus.lesson5hw.csv;

import ru.otus.lesson5hw.service.Question;

import java.util.List;
import java.util.Locale;

/**
 * Created by zhmv on 02.07.2018.
 */
public interface ICSVReader {

    List<Question> getQuestions(Locale locale);
}
