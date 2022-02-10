package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.constants.Constants;
import com.softserveinc.cnh.libraryapi.facade.BookFacade;
import com.softserveinc.cnh.libraryapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BOOK_URL)
public class BookController {

    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

//    @GetMapping
//    public List<Book> getAllBooks() {
//        return bookFacade.findAllBooks();
//    }

    @GetMapping
    public ResponseEntity<List<Book>> filterBooks(@RequestParam Optional<Long> id, @RequestParam Optional<Integer> year,
                                  @RequestParam Optional<String> author, @RequestParam Optional<String> title) {
        if (!id.isPresent() && !year.isPresent() && !author.isPresent() && !title.isPresent()) {
            return ResponseEntity.ok(bookFacade.findAllBooks());
        } else {
            if (id.isPresent()) {
                var singleBookList = new ArrayList<Book>();
                singleBookList.add(bookFacade.findBookById(id.get()));
                return ResponseEntity.ok(singleBookList);
            }
            if (year.isPresent()) {
                return ResponseEntity.ok(bookFacade.findBookByYear(year.get()));
            }
            if (author.isPresent()) {
                return ResponseEntity.ok(bookFacade.findBookByAuthor(author.get()));
            }
            if (title.isPresent()) {
                return ResponseEntity.ok(bookFacade.findBookByTitle(title.get()));
            }
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND );
    }

//    @GetMapping("/book")
//    public Book getBookById(@RequestParam Long id) {
//        return bookFacade.findBookById(id);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookFacade.saveBook(book));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam Long id) {
        bookFacade.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/year")
//    public List<Book> getBookByYear(@RequestParam Integer year) {
//        return bookFacade.findBookByYear(year);
//    }
//
//    @GetMapping("/author")
//    public List<Book> getBookByAuthor(@RequestParam String author) {
//        return bookFacade.findBookByAuthor(author);
//    }
//
//    @GetMapping("/title")
//    public List<Book> getBookByTitle(@RequestParam String title) {
//        return bookFacade.findBookByTitle(title);
//    }
}
