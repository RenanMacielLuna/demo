package com.guru.demo.com.guru.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(String title, String isbn, String publisher) {
        setTitle(title);
        setIsbn(isbn);
        setPublisher(publisher);
    }

    public Book(String title, String isbn, String publisher, Set<Author> authors) {
        setTitle(title);
        setIsbn(isbn);
        setPublisher(publisher);
        setAuthors(authors);
    }
}
