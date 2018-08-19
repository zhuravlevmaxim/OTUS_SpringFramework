package ru.otus.lesson14hw.domain;

/**
 * Created by zhmv on 12.08.2018.
 */
public class Genre {

    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                ", genre='" + genre + '\'' +
                '}';
    }
}
