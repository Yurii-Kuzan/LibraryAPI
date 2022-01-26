package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.model.BookReader;

import java.util.List;

public interface BookReaderService {
    List<BookReader> findBookReadersByReader(Long readerId);

    List<BookReader> findBookReadersByBook(Long bookId);

}
