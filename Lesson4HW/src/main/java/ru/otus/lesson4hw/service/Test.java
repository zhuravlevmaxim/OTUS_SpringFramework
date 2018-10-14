package ru.otus.lesson4hw.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.lesson4hw.csv.ICSVReader;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by zhmv on 02.07.2018.
 */
@Component
@ConfigurationProperties("application")
public class Test {

    private ICSVReader reader;
    private List<Question> questions;
    private double goodPercent;
    private MessageSource messageSource;

    public Test(ICSVReader reader, MessageSource messageSource){
        this.reader = reader;
        this.messageSource = messageSource;
    }

    public void startTest(){
        StringBuilder names = new StringBuilder();
        int count = 0;
        Locale locale = Locale.ROOT;
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Please choose your language!\nПожалуйста выберите ваш язык!\nEN or RU");
            locale.setDefault(getLocale(sc.nextLine().toLowerCase()));
            questions = reader.getQuestions(locale);
            int goodResult = (int)(questions.size() * goodPercent);
            System.out.println(messageSource.getMessage("second.name", null, locale));
            names.append(sc.nextLine());
            System.out.println(messageSource.getMessage("first.name", null, locale));
            names.append(" ");
            names.append(sc.nextLine());
            String name = names.toString();
            System.out.println(messageSource.getMessage("ask.question",  new String[]{name}, locale));
            for (Question question : questions) {
                System.out.println(question.getQuestion());
                if (sc.nextLine().equalsIgnoreCase(question.getAnswer())) {
                    count++;
                }
            }
            if (count >= goodResult) {
                System.out.println(messageSource.getMessage("answer.good",  new String[]{name}, locale));
            } else {
                System.out.println(messageSource.getMessage("answer.bad", new String[]{name}, locale));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ICSVReader getReader() {
        return reader;
    }

    public double getGoodPercent() {
        return goodPercent;
    }

    public void setGoodPercent(double goodPercent) {
        this.goodPercent = goodPercent;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    private Locale getLocale(String localeS){
        Locale locale = null;
        switch (localeS){
            case "en":
                locale = Locale.ENGLISH;
                break;
            case "ru":
                locale = Locale.getDefault();
                break;
            default:
                locale = Locale.getDefault();
        }
        return locale;
    }
}
