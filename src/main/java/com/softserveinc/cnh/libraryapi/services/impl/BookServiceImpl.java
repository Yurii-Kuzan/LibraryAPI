package com.softserveinc.cnh.libraryapi.services.impl;

import com.softserveinc.cnh.libraryapi.dto.model.BookDTO;
import com.softserveinc.cnh.libraryapi.exceptions.ResourceNotFoundException;
import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.repositories.BookRepository;
import com.softserveinc.cnh.libraryapi.services.BookService;
import com.softserveinc.cnh.libraryapi.specification.BookSpecification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " is not exist"));
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> filterBook(BookDTO bookDTO) {
        if (bookDTO.getId() != null) {
            List<Book> singleBookList = new ArrayList<>();
            singleBookList.add(findBookById(bookDTO.getId()));
            return singleBookList;
        }
        Map<String, Object> attributes = new HashMap<>();
        if (bookDTO.getTitle() != null) {
            attributes.put("title", bookDTO.getTitle());
        }
        if (bookDTO.getYear() != null) {
            attributes.put("year", bookDTO.getYear());
        }
        if (bookDTO.getAuthor() != null) {
            attributes.put("author", bookDTO.getAuthor());
        }
        BookSpecification bookSpecification = BookSpecification.create(attributes);
        return bookRepository.findAll(bookSpecification);
    }
}
