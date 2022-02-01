package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.constants.Constants;
import com.softserveinc.cnh.libraryapi.facade.BookFacade;
import com.softserveinc.cnh.libraryapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.BOOK_URL)
public class BookController {

    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookFacade.findAllBooks();
    }

    @GetMapping("/book")
    public Book getBookById(@RequestParam Long id) {
        return bookFacade.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {
        return bookFacade.saveBook(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long id) {
        bookFacade.deleteBookById(id);
    }

    @GetMapping("/year")
    public List<Book> getBookByYear(@RequestParam Integer year) {
        return bookFacade.findBookByYear(year);
    }

    @GetMapping("/author")
    public List<Book> getBookByAuthor(@RequestParam String author) {
        return bookFacade.findBookByAuthor(author);
    }

    @GetMapping("/title")
    public List<Book> getBookByTitle(@RequestParam String title) {
        return bookFacade.findBookByTitle(title);
    }
}
