package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.model.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Long id);

    List<Book> findAllBooks();

    Book saveBook(Book book);

    void deleteBookById(Long id);

    List<Book> findBookByYear(Integer year);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByTitle(String title);
}
