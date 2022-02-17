package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.constants.Constants;
import com.softserveinc.cnh.libraryapi.dto.model.BookDTO;
import com.softserveinc.cnh.libraryapi.facade.BookFacade;
import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.services.BookService;
import com.softserveinc.cnh.libraryapi.validators.impl.BookDtoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BOOK_URL)
public class BookController {

    private final BookFacade bookFacade;
    private final BookService bookService;
    private final BookDtoValidator bookDtoYearValidator;

    public BookController(BookFacade bookFacade, BookService bookService, BookDtoValidator bookDtoYearValidator) {
        this.bookFacade = bookFacade;
        this.bookService = bookService;
        this.bookDtoYearValidator = bookDtoYearValidator;
    }

    @GetMapping
    public ResponseEntity<List<Book>> filterBooks(@RequestParam Optional<Long> id, @RequestParam Optional<Integer> year,
                                                  @RequestParam Optional<String> author, @RequestParam Optional<String> title) {
        if (id.isEmpty() && year.isEmpty() && author.isEmpty() && title.isEmpty()) {
            return ResponseEntity.ok(bookService.findAllBooks());
        } else {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(id.orElse(null));
            bookDTO.setYear(year.orElse(null));
            bookDTO.setAuthor(author.orElse(null));
            bookDTO.setTitle(title.orElse(null));
            //Validate(DTO)
            bookDtoYearValidator.validate(bookDTO);
            return ResponseEntity.ok(bookService.filterBook(bookDTO));
        }
    }

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
}