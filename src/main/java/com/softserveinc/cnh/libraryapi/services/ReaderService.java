package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.model.Reader;

import java.util.List;

public interface ReaderService {
    Reader findReaderById(Long id);

    List<Reader> findAllReaders();

    Reader saveReader(Reader reader);

    void deleteReaderById(Long id);

    List<Reader> findReaderByAge(Integer age);

    List<Reader> findReaderByAddress(String address);

    List<Reader> findReaderByName(String name);
}
