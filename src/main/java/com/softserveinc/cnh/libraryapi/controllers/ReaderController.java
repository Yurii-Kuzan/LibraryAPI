package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.constants.Constants;
import com.softserveinc.cnh.libraryapi.facade.ReaderFacade;
import com.softserveinc.cnh.libraryapi.model.Reader;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.READER_URL)
public class ReaderController {

    private final ReaderFacade readerFacade;

    public ReaderController(ReaderFacade readerFacade) {
        this.readerFacade = readerFacade;
    }

    @GetMapping
    List<Reader> getAllReaders() {
        return readerFacade.findAllReaders();
    }

    @GetMapping("/reader")
    public Reader getReaderById(@RequestParam Long id) {
        return readerFacade.findReaderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reader saveReader(@RequestBody Reader reader) {
        return readerFacade.saveReader(reader);
    }

    @DeleteMapping
    public void deleteReader(@RequestParam Long id) {
        readerFacade.deleteReaderById(id);
    }

    @GetMapping("/age")
    public List<Reader> getReaderByAge(@RequestParam Integer age) {
        return readerFacade.findReaderByAge(age);
    }

    @GetMapping("/address")
    public List<Reader> getReaderByAddress(@RequestParam String address) {
        return readerFacade.findReaderByAddress(address);
    }

    @GetMapping("/name")
    public List<Reader> getReaderByName(@RequestParam String name) {
        return readerFacade.findReaderByName(name);
    }
}
