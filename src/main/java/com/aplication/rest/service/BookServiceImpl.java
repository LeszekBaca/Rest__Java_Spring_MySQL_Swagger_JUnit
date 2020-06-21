package com.aplication.rest.service;

import com.aplication.rest.model.Book;
import com.aplication.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@Service
@Profile({"prod", "test"})
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> book = new ArrayList<>();
        bookRepository.findAll().forEach(e -> book.add(e));
        return book;
    }

    @Override
    public Book getBookById(long bookId) {
        Book obj = bookRepository.findById(bookId).get();
        return obj;
    }


    @Override
    public synchronized boolean addBook(Book book) {
        List<Book> list = bookRepository.findByTitleAndCategory(book.getTitle(), book.getCategory());
        if (list.size() < 0) {
            return false;
        } else {
            bookRepository.save(book);
        }
        return true;
    }

    @Override
    public void updateBook(Book book) {

        List<Book> list = bookRepository.findByTitleAndCategory(book.getTitle(), book.getCategory());
        bookRepository.save(book);
    }



    @Override
    public void deleteBook(int bookId) {
        bookRepository.delete(getBookById(bookId));
    }
}
