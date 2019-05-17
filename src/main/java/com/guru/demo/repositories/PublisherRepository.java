package com.guru.demo.repositories;

import com.guru.demo.com.guru.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
