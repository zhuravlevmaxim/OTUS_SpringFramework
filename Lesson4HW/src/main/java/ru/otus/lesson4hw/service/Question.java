package ru.otus.lesson4hw.service;

/**
 * Created by zhmv on 02.07.2018.
 */
public class Question {
    private String answer;
    private String question;

    public Question(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
