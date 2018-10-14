package ru.otus.lesson23hw.entity;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="author_table")
@Qualifier("AuthorDB")
public class Author  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="second_name")
    private String secondName;

    @ManyToMany
    @JoinTable(name = "book_authors_detail", joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBook(Book book) {
        this.books.add(book);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Author author = (Author) object;
        return this.firstName.equals(author.firstName) && secondName.equals(author.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString() {
        return String.format("|Author: %d, %s, %s|", this.id, this.firstName, this.secondName);
    }
}