package repository;

import model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface BookRepository extends ReactiveCrudRepository<Book, Long> {


}
