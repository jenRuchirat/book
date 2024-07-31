package com.test.book.service;

import com.test.book.entity.BookEntity;
import com.test.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookEntity finding(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookEntity adding(BookEntity book) {
//        LocalDate localDate = LocalDate.parse(book.getPublishedDate().toString(), formatter);
//        book.setPublishedDate(book.getPublishedDate());
        return bookRepository.save(book);
    }
    public BookEntity updating(BookEntity book) {
        if (book != null) {
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleting(Long id) {
        bookRepository.deleteById(id);
    }

}
