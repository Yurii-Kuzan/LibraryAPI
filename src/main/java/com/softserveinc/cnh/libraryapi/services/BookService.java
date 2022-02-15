package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.dto.model.BookDTO;
import com.softserveinc.cnh.libraryapi.model.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Long id);

    List<Book> findAllBooks();

    Book saveBook(Book book);

    void deleteBookById(Long id);

    List<Book> filterBook(BookDTO bookDTO);
}
