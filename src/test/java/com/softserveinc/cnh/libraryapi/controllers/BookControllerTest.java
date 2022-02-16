package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.dto.model.BookDTO;
import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    BookService bookService;

    @InjectMocks
    BookController bookController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void getAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().id(1L).author("Taras").title("Kobzar").year(1977).
                inStockNumber(5).takenBooksNumber(0).build());
        books.add(Book.builder().id(2L).author("Lesya").title("ContraSpemSpero").year(1977).
                inStockNumber(7).takenBooksNumber(0).build());

        BookDTO bookDTO = new BookDTO();
        bookDTO.setYear(1977);

        when(bookService.filterBook(bookDTO)).thenReturn(books);

        mockMvc.perform(get("/books?year=1977")).andExpect(status().is(200));
    }

    @Test
    void getReadersNotFound() throws Exception {
        mockMvc.perform(get("/readers")).andExpect(status().is(404));
    }
}