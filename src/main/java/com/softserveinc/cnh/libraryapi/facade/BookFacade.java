package com.softserveinc.cnh.libraryapi.facade;

import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.services.BookReaderService;
import com.softserveinc.cnh.libraryapi.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class BookFacade {

    private final BookService bookService;

    private final BookReaderService bookReaderService;

    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    public Book findBookById(Long id) {
        return bookService.findBookById(id);
    }

    public Book saveBook(Book book) {
        return bookService.saveBook(book);
    }

    public void deleteBookById(Long id) {
        bookService.deleteBookById(id);
    }
}
