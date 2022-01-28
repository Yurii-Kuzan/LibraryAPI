package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.facade.BookFacade;
import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookController.BOOK_URL)
public class BookController {

    public static final String BOOK_URL = "books";


    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookFacade.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookFacade.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book){
        return bookFacade.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookFacade.deleteBookById(id);
    }

    @GetMapping("/year/{year}")
    public List<Book> getBookByYear(@PathVariable Integer year){
       return bookFacade.findBookByYear(year);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
       return bookFacade.findBookByAuthor(author);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookFacade.findBookByTitle(title);
    }
}
