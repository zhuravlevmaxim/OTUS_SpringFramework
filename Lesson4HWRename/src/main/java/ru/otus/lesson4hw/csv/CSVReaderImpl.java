package ru.otus.lesson4hw.csv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.lesson4hw.service.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zhmv on 02.07.2018.
 */
@Component
@ConfigurationProperties("application")
public class CSVReaderImpl implements ICSVReader {
    //@Value("${filePathRU}")
    //private String filePathRU;
    //@Value("${filePathEN}")
    //private String filePathEN;

    //@Value("${filesPath}")
    private String filesPath;

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }

    public List<Question> getQuestions(Locale locale) {

        System.out.println("filesPath: "+filesPath);

        List<Question> result = null;
        if(locale.getDefault().equals(Locale.ENGLISH)){
            result = getLocaleQuestions(getFilePathFromLocale(locale));
        }else{
            //result = getLocaleQuestions(filePathRU);
        }
        return result;
    }

    private String getFilePathFromLocale(Locale locale){
        String [] filesPathM = filesPath.split(",");
        Map<String, String> pathMap = new HashMap<>();
        for(String path : filesPathM){
            String [] pathTMP = path.split(":");
            pathMap.put(pathTMP[0], pathTMP[1]);
        }
        if(locale.equals(Locale.ENGLISH)){
            return pathMap.get("EN");
        }

        return null;
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

//    public String getFilePathRU() {
//        return filePathRU;
//    }
//
//    public String getFilePathEN() {
//        return filePathEN;
//    }

}
