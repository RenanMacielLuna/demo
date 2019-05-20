package com.guru.demo.bootstrap;

import com.guru.demo.com.guru.model.Author;
import com.guru.demo.com.guru.model.Book;
import com.guru.demo.com.guru.model.Publisher;
import com.guru.demo.repositories.AuthorRepository;
import com.guru.demo.repositories.BookRepository;
import com.guru.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        The line below is commented to not generate duplicate row Content, except ID
//        initData();
    }

    private void initData(){

        //Harper Collins
        Publisher harperCollins = new Publisher("Harper Collins", "5TH Avenue");

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harperCollins);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Wrox
        Publisher wrox = new Publisher("Wrox", "6TH Avenue");

        //Rod
        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);

        publisherRepository.save(wrox);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
