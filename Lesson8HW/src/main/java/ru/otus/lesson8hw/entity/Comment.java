package ru.otus.lesson8hw.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by zhmv on 30.07.2018.
 */
@Entity
@Table(name="comment")
public class Comment {

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

    @Override
    public String toString() {
        return String.format("Comment id: %s, comment: %s", this.id, this.comment);
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
        return this.comment.hashCode();
    }
}
