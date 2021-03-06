package ru.otus.lesson15hw.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by zhmv on 31.08.2018.
 */
@Document
public class Genre {

    @Id
    @Indexed
    private String id;

    @Indexed
    private String genre;

    public Genre(){}

    public Genre(String genre){
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id='" + id + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
