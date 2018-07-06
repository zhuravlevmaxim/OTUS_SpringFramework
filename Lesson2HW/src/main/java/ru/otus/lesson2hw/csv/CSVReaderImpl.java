package ru.otus.lesson2hw.csv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.lesson2hw.service.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by zhmv on 02.07.2018.
 */
@PropertySource("classpath:application.properties")
@Component
public class CSVReaderImpl implements ICSVReader {
    private String filePathRU;
    private String filePathEN;
    public CSVReaderImpl(@Value("${filePathRU}")String filePathRU, @Value("${filePathEN}")String filePathEN){
        this.filePathRU = filePathRU;
        this.filePathEN = filePathEN;
    }

    public List<Question> getQuestions(Locale locale) {
        List<Question> result = null;
        if(locale.getDefault().equals(Locale.ENGLISH)){
            result = getLocaleQuestions(filePathEN);
        }else{
            result = getLocaleQuestions(filePathRU);
        }
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

    public String getFilePathRU() {
        return filePathRU;
    }

    public String getFilePathEN() {
        return filePathEN;
    }

}
