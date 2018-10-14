package ru.otus.lesson1HW.service;

import ru.otus.lesson1HW.csv.ICSVReader;

import java.util.List;
import java.util.Scanner;

/**
 * Created by zhmv on 30.06.2018.
 */
public class Test {

    private ICSVReader reader;
    private int count;

    public Test(ICSVReader reader){
        this.reader = reader;
    }

    public void startTest(){
        String firstName, secondName;
        try(Scanner sc = new Scanner(System.in)) {
            List<Question> questions = reader.getQuestions();
            System.out.println("Напишите вашу фамилию!");
            secondName = sc.nextLine();
            System.out.println("Напишите ваше имя!");
            firstName = sc.nextLine();
            String name = secondName + " " + firstName;
            System.out.println( name+ " ответьте на вопросы!");
            for (Question question : questions) {
                System.out.println(question.getQuestion());
                if (sc.nextLine().equalsIgnoreCase(question.getAnswer())) {
                    count++;
                }
            }
            if (count >= (questions.size() * 70) / 100) {
                System.out.println(name + " вы сдали тест!");
            } else {
                System.out.println(name + " вы не сдали тест!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
