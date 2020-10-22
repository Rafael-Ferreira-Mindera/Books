package com.example.repository;

import com.example.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface BookRepository extends ReactiveCrudRepository<Book, Long> {


}
