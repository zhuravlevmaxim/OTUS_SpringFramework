package ru.otus.lesson23hw.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="comment_table")
public class Comment  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="comment")
    private String comment;


    @ManyToMany
    @JoinTable(name = "book_comments_detail", joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setBook(Book book){
        books.add(book);
    }

    @Override
    public String toString() {
        return String.format("|Comment id: %d, comment: %s|", this.id, this.comment);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Comment comment = (Comment) object;
        return this.comment.equals(comment.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}