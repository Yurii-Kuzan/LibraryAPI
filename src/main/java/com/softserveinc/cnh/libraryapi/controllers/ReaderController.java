package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.facade.ReaderFacade;
import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ReaderController.READER_URL)
public class ReaderController {

    public static final String READER_URL = "readers";


    private final ReaderFacade readerFacade;

    public ReaderController(ReaderFacade readerFacade) {
        this.readerFacade = readerFacade;
    }

    @GetMapping
    List<Reader> getAllReaders() {
        return readerFacade.findAllReaders();
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable Long id) {
        return readerFacade.findReaderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reader saveReader(@RequestBody Reader reader) {
        return readerFacade.saveReader(reader);
    }

    @GetMapping("/delete/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerFacade.deleteReaderById(id);
    }

    @GetMapping("/age/{age}")
    public List<Reader> getReaderByAge(@PathVariable Integer age) {
        return readerFacade.findReaderByAge(age);
    }

    @GetMapping("/address/{address}")
    public List<Reader> getReaderByAddress(@PathVariable String address) {
        return readerFacade.findReaderByAddress(address);
    }

    @GetMapping("/name/{name}")
    public List<Reader> getReaderByName(@PathVariable String name) {
        return readerFacade.findReaderByName(name);
    }
}
