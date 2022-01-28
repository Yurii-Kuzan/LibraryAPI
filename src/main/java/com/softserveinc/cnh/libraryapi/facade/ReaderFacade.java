package com.softserveinc.cnh.libraryapi.facade;

import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.services.BookReaderService;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ReaderFacade {

    @Autowired
    private final ReaderService readerService;
    @Autowired
    private final BookReaderService bookReaderService;

    public Reader findReaderById(Long id){
        return readerService.findReaderById(id);
    }

    public List<Reader> findAllReaders(){
        return readerService.findAllReaders();
    }

    public Reader saveReader(Reader reader){
        return readerService.saveReader(reader);
    }

    public void deleteReaderById(Long id){
        readerService.deleteReaderById(id);
    }

    public List<Reader> findReaderByAge(Integer age){
        return readerService.findReaderByAge(age);
    }

    public List<Reader> findReaderByAddress(String address){
        return readerService.findReaderByAddress(address);
    }

    public List<Reader> findReaderByName(String name){
        return readerService.findReaderByName(name);
    }
}
