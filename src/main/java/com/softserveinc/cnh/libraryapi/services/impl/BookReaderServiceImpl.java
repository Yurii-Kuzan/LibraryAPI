package com.softserveinc.cnh.libraryapi.services.impl;

import com.softserveinc.cnh.libraryapi.model.BookReader;
import com.softserveinc.cnh.libraryapi.repositories.BookReaderRepository;
import com.softserveinc.cnh.libraryapi.services.BookReaderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReaderServiceImpl implements BookReaderService {

    private final BookReaderRepository bookReaderRepository;

    public BookReaderServiceImpl(BookReaderRepository bookReaderRepository) {
        this.bookReaderRepository = bookReaderRepository;
    }

    @Override
    public List<BookReader> findBookReadersByReader(Long readerId) {
        return bookReaderRepository.findBookReadersByReader(readerId);
    }

    @Override
    public List<BookReader> findBookReadersByBook(Long bookId) {
        return bookReaderRepository.findBookReadersByBook(bookId);
    }
}
