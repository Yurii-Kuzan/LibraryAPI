package com.softserveinc.cnh.libraryapi.facade;

import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.services.BookReaderService;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ReaderFacade {

    private final ReaderService readerService;

    private final BookReaderService bookReaderService;

    public Reader findReaderById(Long id) {
        return readerService.findReaderById(id);
    }

    public List<Reader> findAllReaders() {
        return readerService.findAllReaders();
    }

    public Reader saveReader(Reader reader) {
        return readerService.saveReader(reader);
    }

    public void deleteReaderById(Long id) {
        readerService.deleteReaderById(id);
    }
}
