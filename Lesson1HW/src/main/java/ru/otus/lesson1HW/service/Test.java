package ru.otus.lesson1HW.service;

import ru.otus.lesson1HW.csv.ICSVReader;

import java.util.List;
import java.util.Scanner;

/**
 * Created by zhmv on 30.06.2018.
 */
public class Test {

    private ICSVReader reader;
    public Test(ICSVReader reader){
        this.reader = reader;
    }

    public void startTest(){
        String firstName, secondName;
        Scanner sc = new Scanner(System.in);
        List<Question> questions = reader.getQuestions();
        System.out.println("Напишите вашу фамилию!");
        secondName = sc.nextLine();
        System.out.println("Напишите ваше имя!");
        firstName = sc.nextLine();
        System.out.println(secondName + " " +firstName + " ответьте на вопросы!");
        int count = 0;
        for(Question question : questions){
            System.out.println(question.getQuestion());
            if(sc.nextLine().equalsIgnoreCase(question.getAnswer())){
                count++;
            }
        }
        if(count >= 3){
            System.out.println(secondName + " " +firstName + " вы сдали тест!");
        }else{
            System.out.println(secondName + " " +firstName + " вы не сдали тест!");
        }
        sc.close();
    }
}
