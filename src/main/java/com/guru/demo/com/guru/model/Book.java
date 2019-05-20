package com.guru.demo.com.guru.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter(value = AccessLevel.PACKAGE)
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @OneToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(String title, String isbn, Publisher publisher) {
        setTitle(title);
        setIsbn(isbn);
        setPublisher(publisher);
    }

    public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
        setTitle(title);
        setIsbn(isbn);
        setPublisher(publisher);
        setAuthors(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher.getName() + '\'' +
                ", authors=" + authors +
                '}';
    }
}
