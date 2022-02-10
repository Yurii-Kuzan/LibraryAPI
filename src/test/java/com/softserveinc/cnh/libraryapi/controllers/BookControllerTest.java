package com.softserveinc.cnh.libraryapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.softserveinc.cnh.libraryapi.facade.BookFacade;
import com.softserveinc.cnh.libraryapi.model.Book;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    BookFacade bookFacade;

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
        books.add(Book.builder().id(2L).author("Lesya").title("ContraSpemSpero").year(1978).
                inStockNumber(7).takenBooksNumber(0).build());

        when(bookFacade.findAllBooks()).thenReturn(books);

        mockMvc.perform(get("/books")).andExpect(status().is(200));
    }

    @Test
    void getReadersNotFound() throws Exception {
        mockMvc.perform(get("/readers")).andExpect(status().is(404));
    }
}