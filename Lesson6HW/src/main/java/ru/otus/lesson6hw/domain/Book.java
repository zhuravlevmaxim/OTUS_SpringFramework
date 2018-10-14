package ru.otus.lesson6hw.domain;

/**
 * Created by zhmv on 16.07.2018.
 */
public class Book {
    private int id;
    private String name;
    private String description;

    private int id_author;
    private Author author;

    private int id_genre;
    private Genre genre;

    public int getId() {
        return id;
    }

    public Book(int id, String name, String description,
                Author author, Genre genre){
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("BOOK_ID: %d, NAME: %s, DESCRIPTION: %s, AUTHOR: %s, GENRE: %s",
                this.id, this.name, this.description, this.author, this.genre);
    }
}
