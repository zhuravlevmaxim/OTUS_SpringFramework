package ru.otus.lesson4hw.csv;

import ru.otus.lesson4hw.service.Question;

import java.util.List;
import java.util.Locale;

/**
 * Created by zhmv on 02.07.2018.
 */
public interface ICSVReader {

    public List<Question> getQuestions(Locale locale);
}
