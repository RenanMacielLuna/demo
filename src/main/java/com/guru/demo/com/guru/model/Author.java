package com.guru.demo.com.guru.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter(value = AccessLevel.PACKAGE)
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(fisrtName, author.fisrtName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(books, author.books);
    }
}
