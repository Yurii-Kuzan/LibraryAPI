package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.exceptions.ResourceNotFoundException;
import com.softserveinc.cnh.libraryapi.model.Book;
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
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findBookById() {
        Long idValue = 1L;
        Book b1 =  Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();

        when(bookRepository.findById(any())).thenReturn(java.util.Optional.of(b1));
        Book returnedBook = bookService.findBookById(idValue);

        assertEquals(idValue, returnedBook.getBookId());

        verify(bookRepository).findById(any());
    }

    @Test
    void findBookById_ExceptionThrown() {
        Long idValue = 1L;
        ResourceNotFoundException thrown = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> bookService.findBookById(idValue), "Book with id " + idValue + " is not exist");
        assertEquals("Book with id " + idValue + " is not exist", thrown.getMessage());
    }

    @Test
    void findAllBooks() {
        long idValue = 1L;
        Book b1 =  Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        long idValue2 = 2L;
        Book b2 = Book.builder().bookId(idValue2).author("Lesya").title("ContraSpemSpero").year(1978).
                inStockNumber(7).takenBooksNumber(0).build();

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);

        when(bookRepository.findAll()).thenReturn(books);
        List<Book> returnedBooks = bookService.findAllBooks();

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 2);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findAll();
    }

    @Test
    void findBookByYear() {
        long idValue = 1L;
        Book b1 =  Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        List<Book> books = new ArrayList<>();
        books.add(b1);

        when(bookRepository.findBookByYear(1977)).thenReturn(books);
        List<Book> returnedBooks = bookService.findBookByYear(1977);

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 1);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findBookByYear(1977);
    }

    @Test
    void findBookByAuthor() {
        long idValue = 1L;
        Book b1 =  Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        List<Book> books = new ArrayList<>();
        books.add(b1);

        when(bookRepository.findBookByAuthor("Taras")).thenReturn(books);
        List<Book> returnedBooks = bookService.findBookByAuthor("Taras");

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 1);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findBookByAuthor("Taras");
    }

    @Test
    void findBookByTitle() {
        long idValue = 1L;
        Book b1 =  Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        List<Book> books = new ArrayList<>();
        books.add(b1);

        when(bookRepository.findBookByTitle("Kobzar")).thenReturn(books);
        List<Book> returnedBooks = bookService.findBookByTitle("Kobzar");

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 1);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findBookByTitle("Kobzar");
    }

    @Test
    void saveBook() {
        long idValue = 1L;
        Book b1 =  Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();

        when(bookRepository.save(any())).thenReturn(b1);
        Book returnedBook = bookService.saveBook(b1);

        assertEquals(returnedBook.getBookId(), idValue);
        verify(bookRepository).save(b1);
    }

    @Test
    void deleteBookById() {
        Long idValue = 1L;

        bookService.deleteBookById(idValue);
        verify(bookRepository).deleteById(idValue);
    }

}