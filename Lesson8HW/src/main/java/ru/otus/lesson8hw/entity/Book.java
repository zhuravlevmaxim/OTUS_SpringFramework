package ru.otus.lesson8hw.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhmv on 30.07.2018.
 */
@Entity
@Table(name="table")
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
