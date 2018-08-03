package ru.otus.lesson8hw.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by zhmv on 30.07.2018.
 */
@Entity
@Table(name="book_table")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToOne
    private Author author;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "book_comments_detail", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<Comment> comments = new HashSet<>();

    public void setComment(Comment comment){
        this.comments.add(comment);
    }

    public void setGenre(Genre genre){
        this.genres.add(genre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(description, book.description) &&
                Objects.equals(author, book.author) &&
                Objects.equals(genres, book.genres) &&
                Objects.equals(comments, book.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, author, genres, comments);
    }

    @Override
    public String toString() {
        return String.format("|Book id: %d, name: %s, description: %s, author: %s, genres: %s, comments: %s|",
                this.id, this.name, this.description, this.author, this.genres, this.comments);
    }
}
