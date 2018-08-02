package ru.otus.lesson8hw.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by zhmv on 30.07.2018.
 */
@Entity
@Table(name="author_table")
public class Author  implements Serializable {

    public Author(){}

    public Author(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="secomd_name")
    private String secondName;

    @OneToOne
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
        return this.firstName.hashCode() + this.secondName.hashCode();
    }
}
