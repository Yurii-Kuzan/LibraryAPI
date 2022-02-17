package com.softserveinc.cnh.libraryapi.controllers;

import com.softserveinc.cnh.libraryapi.constants.Constants;
import com.softserveinc.cnh.libraryapi.dto.model.ReaderDTO;
import com.softserveinc.cnh.libraryapi.facade.ReaderFacade;
import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import com.softserveinc.cnh.libraryapi.validators.impl.ReaderDtoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.READER_URL)
public class ReaderController {

    private final ReaderFacade readerFacade;
    private final ReaderService readerService;
    private final ReaderDtoValidator readerDtoValidator;

    public ReaderController(ReaderFacade readerFacade, ReaderService readerService, ReaderDtoValidator readerDtoValidator) {
        this.readerFacade = readerFacade;
        this.readerService = readerService;
        this.readerDtoValidator = readerDtoValidator;
    }

    @GetMapping
    public ResponseEntity<List<Reader>> filterReaders(@RequestParam Optional<Long> id, @RequestParam Optional<Integer> age,
                                                      @RequestParam Optional<String> address, @RequestParam Optional<String> name) {
        if (id.isEmpty() && age.isEmpty() && address.isEmpty() && name.isEmpty()) {
            return ResponseEntity.ok(readerService.findAllReaders());
        } else {
            ReaderDTO readerDTO = new ReaderDTO();
            readerDTO.setId(id.orElse(null));
            readerDTO.setAge(age.orElse(null));
            readerDTO.setAddress(address.orElse(null));
            readerDTO.setFirstName(name.orElse(null));

            readerDtoValidator.validate(readerDTO);
            return ResponseEntity.ok(readerService.filterReaders(readerDTO));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reader> saveReader(@RequestBody Reader reader) {
        return ResponseEntity.ok(readerService.saveReader(reader));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReader(@RequestParam Long id) {
        readerService.deleteReaderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
