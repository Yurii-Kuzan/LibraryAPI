package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBookByYear(Integer year) {
        return bookRepository.findBookByYear(year);
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthor(author);
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }
}
