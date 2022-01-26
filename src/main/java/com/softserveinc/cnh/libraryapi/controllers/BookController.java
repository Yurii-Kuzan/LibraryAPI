package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.facade.BookReaderFacade;
import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookController.BOOK_URL)
public class BookController {

    public static final String BOOK_URL = "books";

    private final BookService bookService;
   // private final BookReaderFacade bookReaderFacade;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        //this.bookReaderFacade = bookReaderFacade;
    }

    @GetMapping
    List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }

    @GetMapping("/year/{year}")
    public List<Book> getBookByYear(@PathVariable Integer year){
       return bookService.findBookByYear(year);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
       return bookService.findBookByAuthor(author);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.findBookByTitle(title);
    }
}
