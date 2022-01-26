package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.facade.BookReaderFacade;
import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ReaderController.READER_URL)
public class ReaderController {

    public static final String READER_URL = "readers";

    private final ReaderService readerService;
  //  private final BookReaderFacade bookReaderFacade;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
        //this.bookReaderFacade = bookReaderFacade;
    }

    @GetMapping
    List<Reader> getAllReaders() {
        return readerService.findAllReaders();
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable Long id) {
        return readerService.findReaderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reader saveReader(@RequestBody Reader reader) {
        return readerService.saveReader(reader);
    }

    @GetMapping("/delete/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReaderById(id);
    }

    @GetMapping("/age/{age}")
    public List<Reader> getReaderByAge(@PathVariable Integer age) {
        return readerService.findReaderByAge(age);
    }

    @GetMapping("/address/{address}")
    public List<Reader> getReaderByAddress(@PathVariable String address) {
        return readerService.findReaderByAddress(address);
    }

    @GetMapping("/name/{name}")
    public List<Reader> getReaderByName(@PathVariable String name) {
        return readerService.findReaderByName(name);
    }
}
