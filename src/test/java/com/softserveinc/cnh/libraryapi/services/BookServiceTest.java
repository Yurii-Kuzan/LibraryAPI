package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.exceptions.ResourceNotFoundException;
import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.repositories.BookRepository;
import com.softserveinc.cnh.libraryapi.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

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

    /**
     * ArgumentCaptor added
     */
    @Test
    void findBookById_BookReturned() {
        var idValue = 1L;
        var b1 = Book.builder().id(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();

        when(bookRepository.findById(any())).thenReturn(java.util.Optional.of(b1));
        var returnedBook = bookService.findBookById(idValue);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);

        assertEquals(idValue, returnedBook.getId());

        verify(bookRepository).findById(argumentCaptor.capture());
        assertEquals(idValue, argumentCaptor.getValue());
    }

    @Test
    void findBookById_BookNotFoundCase() {
        var idValue = 1L;
        ResourceNotFoundException thrown = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> bookService.findBookById(idValue), "Book with id " + idValue + " is not exist");
    }

    /**
     * Spy added
     */
    @Test
    void findAllBooks_BooksReturned() {
        var idValue = 1L;
        var b1 = Book.builder()
                .id(idValue)
                .author("Taras")
                .title("Kobzar")
                .year(1977)
                .inStockNumber(5)
                .takenBooksNumber(0)
                .build();


        var idValue2 = 2L;
        var b2 = Book.builder().id(idValue2).author("Lesya").title("ContraSpemSpero").year(1978).
                inStockNumber(7).takenBooksNumber(0).build();

        var books = new ArrayList<Book>();
        books.add(b1);
        books.add(b2);

        when(bookRepository.findAll()).thenReturn(books);
        var returnedBooks = bookService.findAllBooks();

        var spyList = Mockito.spy(books);
        assertEquals(spyList.size(), 2);

        Mockito.doReturn(0).when(spyList).size();
        assertEquals(spyList.size(), 0);

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 2);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findAll();
    }

    @Test
    void findAllBooks_ReturnedEmptyBooksList() {
        var books = new ArrayList<Book>();

        when(bookRepository.findAll()).thenReturn(books);
        var returnedBooks = bookService.findAllBooks();

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findAll();
    }


    @Test
    void findBookByYear_BooksReturned() {
        var idValue = 1L;
        var b1 = Book.builder().id(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        var books = new ArrayList<Book>();
        books.add(b1);

        when(bookRepository.findBookByYear(1977)).thenReturn(books);
        var returnedBooks = bookService.findBookByYear(1977);

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 1);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findBookByYear(1977);
    }

    @Test
    void findBookByYear_ReturnedEmptyBooksList() {
        var books = new ArrayList<Book>();

        when(bookRepository.findBookByYear(1977)).thenReturn(books);
        var returnedBooks = bookService.findBookByYear(1977);

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findBookByYear(1977);
    }

    @Test
    void findBookByAuthor_BooksReturned() {
        var idValue = 1L;
        var b1 = Book.builder().id(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        var books = new ArrayList<Book>();
        books.add(b1);

        when(bookRepository.findBookByAuthor("Taras")).thenReturn(books);
        var returnedBooks = bookService.findBookByAuthor("Taras");

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 1);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findBookByAuthor("Taras");
    }

    @Test
    void findBookByAuthor_ReturnedEmptyBooksList() {
        var books = new ArrayList<Book>();

        when(bookRepository.findBookByAuthor("Taras")).thenReturn(books);
        var returnedBooks = bookService.findBookByAuthor("Taras");

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findBookByAuthor("Taras");
    }

    @Test
    void findBookByTitle_BooksReturned() {
        var idValue = 1L;
        var b1 = Book.builder().id(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        var books = new ArrayList<Book>();
        books.add(b1);

        when(bookRepository.findBookByTitle("Kobzar")).thenReturn(books);
        var returnedBooks = bookService.findBookByTitle("Kobzar");

        assertNotNull(returnedBooks);
        assertEquals(returnedBooks.size(), 1);
        assertEquals(returnedBooks.get(0), b1);

        verify(bookRepository).findBookByTitle("Kobzar");
    }

    @Test
    void findBookByTitle_ReturnedEmptyBooksList() {
        var books = new ArrayList<Book>();

        when(bookRepository.findBookByTitle("Kobzar")).thenReturn(books);
        var returnedBooks = bookService.findBookByTitle("Kobzar");

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findBookByTitle("Kobzar");
    }

    @Test
    void saveBook_BookSaved() {
        var idValue = 1L;
        var b1 = Book.builder().id(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();

        when(bookRepository.save(any())).thenReturn(b1);
        var returnedBook = bookService.saveBook(b1);

        assertEquals(returnedBook.getId(), idValue);

        verify(bookRepository).save(b1);
    }

    @Test
    void deleteBookById_BookDeleted() {
        var idValue = 1L;

        bookService.deleteBookById(idValue);

        verify(bookRepository).deleteById(idValue);
    }

}