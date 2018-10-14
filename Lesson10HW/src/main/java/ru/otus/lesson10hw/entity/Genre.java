package ru.otus.lesson10hw.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by zhmv on 30.07.2018.
 */
@Entity
@Table(name="genre_table")
public class Genre  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return String.format("Genre: id: %d, genre: %s", this.id, this.genre);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Genre genre = (Genre) object;
        return this.genre.equals(genre.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre);
    }
}
