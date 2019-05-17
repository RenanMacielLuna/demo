package com.guru.demo.repositories;

import com.guru.demo.com.guru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
