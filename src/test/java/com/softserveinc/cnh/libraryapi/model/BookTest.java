package com.softserveinc.cnh.libraryapi.model;

import com.softserveinc.cnh.libraryapi.exceptions.BookNotFoundException;
import com.softserveinc.cnh.libraryapi.repositories.BookRepository;
import com.softserveinc.cnh.libraryapi.services.BookService;
import com.softserveinc.cnh.libraryapi.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookService bookService;

    @BeforeEach
    public void setUp(){
        book = new Book();
    }

    @Test
    void getBookId_ValidValue() {
        Long idValue = 1L;
        book.setBookId(idValue);

        assertEquals(idValue, book.getBookId());
    }

    /**
     * The test falls with nullPointer
     */
    @Test
    void getBookById_ValidValue() {
        Long idValue = 1L;
        Book b1 = new Book();
        b1.setBookId(idValue);
        b1.setAuthor("Taras");
        b1.setTitle("Kobzar");
        b1.setInStockNumber(5);
        b1.setTakenBooksNumber(0);
        b1.setYear(1977);

        bookRepository.save(b1);

        assertEquals(b1, bookService.findBookById(idValue));
    }

    /**
     * The test falls with nullPointer
     */
    @Test
    void getBookById_InvalidValue() {
        Long idValue = 1L;
        BookNotFoundException thrown = Assertions.assertThrows(BookNotFoundException.class, ()-> {
            bookService.findBookById(idValue);
        }, "Book with id " + idValue +" is not exist");
        assertEquals("Book with id " + idValue +" is not exist", thrown.getMessage());
    }

    @Test
    void getTitle() {
        String title = "Kobzar";
        book.setTitle(title);

        assertEquals(title, book.getTitle());
    }

    @Test
    void getAuthor() {
        String author = "Taras Shevchenko";
        book.setAuthor(author);

        assertEquals(author, book.getAuthor());
    }

    @Test
    void getYear() {
        Integer year = 1977;
        book.setYear(year);

        assertEquals(year, book.getYear());
    }
}