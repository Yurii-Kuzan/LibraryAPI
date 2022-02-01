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

    /**
     * ArgumentCaptor added
     */
    @Test
    void findBookById_BookReturned() {
        Long idValue = 1L;
        Book b1 = Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();

        when(bookRepository.findById(any())).thenReturn(java.util.Optional.of(b1));
        Book returnedBook = bookService.findBookById(idValue);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);

        assertEquals(idValue, returnedBook.getBookId());

        verify(bookRepository).findById(argumentCaptor.capture());
        assertEquals(idValue, argumentCaptor.getValue());
    }

    @Test
    void findBookById_BookNotFoundCase() {
        Long idValue = 1L;
        ResourceNotFoundException thrown = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> bookService.findBookById(idValue), "Book with id " + idValue + " is not exist");
        assertEquals("Book with id " + idValue + " is not exist", thrown.getMessage());
    }

    /**
     * Spy added
     */
    @Test
    void findAllBooks_BooksReturned() {
        long idValue = 1L;
        Book b1 = Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();


        long idValue2 = 2L;
        Book b2 = Book.builder().bookId(idValue2).author("Lesya").title("ContraSpemSpero").year(1978).
                inStockNumber(7).takenBooksNumber(0).build();

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);

        when(bookRepository.findAll()).thenReturn(books);
        List<Book> returnedBooks = bookService.findAllBooks();

        List<Book> spyList = Mockito.spy(books);
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
        List<Book> books = new ArrayList<>();

        when(bookRepository.findAll()).thenReturn(books);
        List<Book> returnedBooks = bookService.findAllBooks();

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findAll();
    }


    @Test
    void findBookByYear_BooksReturned() {
        long idValue = 1L;
        Book b1 = Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
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
    void findBookByYear_ReturnedEmptyBooksList() {
        List<Book> books = new ArrayList<>();

        when(bookRepository.findBookByYear(1977)).thenReturn(books);
        List<Book> returnedBooks = bookService.findBookByYear(1977);

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findBookByYear(1977);
    }

    @Test
    void findBookByAuthor_BooksReturned() {
        long idValue = 1L;
        Book b1 = Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
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
    void findBookByAuthor_ReturnedEmptyBooksList() {
        List<Book> books = new ArrayList<>();

        when(bookRepository.findBookByAuthor("Taras")).thenReturn(books);
        List<Book> returnedBooks = bookService.findBookByAuthor("Taras");

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findBookByAuthor("Taras");
    }

    @Test
    void findBookByTitle_BooksReturned() {
        long idValue = 1L;
        Book b1 = Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
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
    void findBookByTitle_ReturnedEmptyBooksList() {
        List<Book> books = new ArrayList<>();

        when(bookRepository.findBookByTitle("Kobzar")).thenReturn(books);
        List<Book> returnedBooks = bookService.findBookByTitle("Kobzar");

        assertTrue(returnedBooks.isEmpty());

        verify(bookRepository).findBookByTitle("Kobzar");
    }

    @Test
    void saveBook_BookSaved() {
        long idValue = 1L;
        Book b1 = Book.builder().bookId(idValue).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build();

        when(bookRepository.save(any())).thenReturn(b1);
        Book returnedBook = bookService.saveBook(b1);

        assertEquals(returnedBook.getBookId(), idValue);
        verify(bookRepository).save(b1);
    }

    @Test
    void deleteBookById_BookDeleted() {
        Long idValue = 1L;

        bookService.deleteBookById(idValue);
        verify(bookRepository).deleteById(idValue);
    }

}