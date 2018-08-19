package ru.otus.lesson14hw.domain;

/**
 * Created by zhmv on 17.08.2018.
 */
public class Comment {

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                ", comment='" + comment + '\'' +
                '}';
    }
}
