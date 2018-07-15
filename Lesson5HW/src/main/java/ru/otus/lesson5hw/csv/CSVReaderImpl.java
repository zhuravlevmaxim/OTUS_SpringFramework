package ru.otus.lesson5hw.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.lesson5hw.service.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zhmv on 02.07.2018.
 */
@Component
public class CSVReaderImpl implements ICSVReader {

    @Autowired
    private CSVReaderConfig csvReaderConfig;

    public CSVReaderConfig getCsvReaderConfig() {
        return csvReaderConfig;
    }

    public void setCsvReaderConfig(CSVReaderConfig csvReaderConfig) {
        this.csvReaderConfig = csvReaderConfig;
    }

    public List<Question> getQuestions(Locale locale) {
        List<Question> result = getLocaleQuestions(csvReaderConfig.getFilePathFromLocale(locale));
        return result;
    }

    private List<Question> getLocaleQuestions(String filePath){
        List<Question> result = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath),"utf-8"))) {
            String str;
            while((str = br.readLine()) != null ) {
                String[] answers = str.split(";");
                result.add(new Question(answers[0], answers[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
