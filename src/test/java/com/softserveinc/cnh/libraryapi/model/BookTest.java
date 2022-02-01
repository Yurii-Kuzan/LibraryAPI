package com.softserveinc.cnh.libraryapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book();
    }

    @Test
    void getBookId() {
        var idValue = 1L;
        book.setBookId(idValue);

        assertEquals(idValue, book.getBookId());
    }


    @Test
    void getTitle() {
        var title = "Kobzar";
        book.setTitle(title);

        assertEquals(title, book.getTitle());
    }

    @Test
    void getAuthor() {
        var author = "Taras Shevchenko";
        book.setAuthor(author);

        assertEquals(author, book.getAuthor());
    }

    @Test
    void getYear() {
        var year = 1977;
        book.setYear(year);

        assertEquals(year, book.getYear());
    }
}