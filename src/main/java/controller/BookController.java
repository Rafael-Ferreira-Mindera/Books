package controller;



import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.BookRepository;


@RestController
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository){
        logger.debug("OLA");
        this.bookRepository = bookRepository;
    }

    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Book> getBook(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Book> newBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    private Mono deleteBook(@PathVariable Long id) {
        return bookRepository.deleteById(id);
    }




}
