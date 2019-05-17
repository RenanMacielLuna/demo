package com.guru.demo.repositories;

import com.guru.demo.com.guru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
