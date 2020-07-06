package com.aplication.rest.service;

import com.aplication.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(long bookId);

    boolean addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int bookId);

}
