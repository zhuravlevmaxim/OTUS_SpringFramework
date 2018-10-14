package ru.otus.lesson5hw.csv;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by zhmv on 15.07.2018.
 */
@Component
@ConfigurationProperties("application")
public class CSVReaderConfig {

    private String filesPath;

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }

    public String getFilesPath() {
        return filesPath;
    }

    public String getFilePathFromLocale(Locale locale){
        String [] filesPathM = filesPath.split(",");
        Map<String, String> pathMap = new HashMap<>();
        for(String path : filesPathM){
            String [] pathTMP = path.split(":");
            pathMap.put(pathTMP[0].toLowerCase(), pathTMP[1]);
        }
        if(locale.getDefault().equals(Locale.ENGLISH)){
            return pathMap.get("en");
        }else{
            return pathMap.get("ru");
        }
    }
}
