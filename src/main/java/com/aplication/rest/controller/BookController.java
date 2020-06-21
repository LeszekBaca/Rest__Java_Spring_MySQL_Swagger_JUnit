package com.aplication.rest.controller;

import com.aplication.rest.Exception.BookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aplication.rest.model.Book;
import com.aplication.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) throws BookException {
        logger.info("Book id to return " + id);
        Book book = bookService.getBookById(id);

        if (book == null || book.getId() <= 0) {
            throw new BookException("Book doesn´t exist");
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> book = bookService.getAllBooks();
        logger.info("Returning all books");
        return new ResponseEntity<List<Book>>(book, HttpStatus.OK);

    }

    @PostMapping("book")
    public ResponseEntity<Void> addBook(@RequestBody Book book, UriComponentsBuilder builder) {
        boolean state = bookService.addBook(book);
        if (state == false) {

            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) throws BookException {

        Book currentBook = bookService.getBookById(id);
        if (currentBook == null || currentBook.getId() <= 0) {
            throw new BookException("Book to update doesn´t exist");
        }
        currentBook.setTitle(book.getTitle());
        currentBook.setDescription(book.getDescription());
        currentBook.setIsbn(book.getIsbn());
        currentBook.setCategory(book.getCategory());
        currentBook.setAutor(book.getAutor());

        bookService.updateBook(currentBook);

        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);

    }


    @DeleteMapping("book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) throws BookException {

        Book currentBook = bookService.getBookById(id);
        if (currentBook == null || currentBook.getId() <= 0) {
            throw new BookException("Book to delete doesn´t exist");
        }
        bookService.deleteBook(id);
        logger.info("Book id to remove " + id);

        return new ResponseEntity<Void>(HttpStatus.OK);


    }
}

