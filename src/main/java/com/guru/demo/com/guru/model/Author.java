package com.guru.demo.com.guru.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String fisrtName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


    public Author(String fisrtName, String lastName) {
        setFisrtName(fisrtName);
        setLastName(lastName);
    }

    public Author (String fisrtName, String lastName, Set<Book> books) {
        setFisrtName(fisrtName);
        setLastName(lastName);
        setBooks(books);
    }
}
