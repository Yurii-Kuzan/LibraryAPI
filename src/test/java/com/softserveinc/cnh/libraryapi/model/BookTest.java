package com.softserveinc.cnh.libraryapi.model;

import com.softserveinc.cnh.libraryapi.exceptions.BookNotFoundException;
import com.softserveinc.cnh.libraryapi.repositories.BookRepository;
import com.softserveinc.cnh.libraryapi.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookTest {

    private Book book;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

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
     * Test fixed
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

        when(bookRepository.findById(any())).thenReturn(java.util.Optional.of(b1));
        Book returnedBook = bookService.findBookById(idValue);

        assertEquals(idValue, returnedBook.getBookId());

        verify(bookRepository).findById(any());
    }

    @Test
    void getAllBooks_ValidValue() {
        Long idValue = 1L;
        Long idValue2 = 2L;
        Book b1 = new Book();
        b1.setBookId(idValue);
        b1.setAuthor("Taras");
        b1.setTitle("Kobzar");
        b1.setInStockNumber(5);
        b1.setTakenBooksNumber(0);
        b1.setYear(1977);

        Book b2 = new Book();
        b2.setBookId(idValue2);
        b2.setAuthor("Lesya");
        b2.setTitle("ContraSpemSpero");
        b2.setInStockNumber(7);
        b2.setTakenBooksNumber(0);
        b2.setYear(1978);

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);

        when(bookRepository.findAll()).thenReturn(books);
        List<Book> returnedBooks = bookService.findAllBooks();

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(),2);
        assertEquals(returnedBooks.get(0),b1);

        verify(bookRepository).findAll();
    }

    /**
     * Fixed test
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