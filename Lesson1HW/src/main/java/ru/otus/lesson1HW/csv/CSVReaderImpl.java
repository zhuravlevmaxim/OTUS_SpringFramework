package ru.otus.lesson1HW.csv;

import ru.otus.lesson1HW.service.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhmv on 30.06.2018.
 */
public class CSVReaderImpl implements ICSVReader {

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;

    public CSVReaderImpl(){}

    public CSVReaderImpl(String filePath){
        this.filePath = filePath;
    }

    public List<Question> getQuestions() {
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
