package ru.otus.lesson6hw.domain;

/**
 * Created by zhmv on 16.07.2018.
 */
public class Genre {

    private int id;
    private String genreName;

    public Genre(int id, String genreName){
        this.id = id;
        this.genreName = genreName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return String.format("GENRE_ID: %d, GENRE_NAME: %s", this.id, this.genreName);
    }
}
