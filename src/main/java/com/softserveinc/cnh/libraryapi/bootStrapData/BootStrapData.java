package com.softserveinc.cnh.libraryapi.bootStrapData;

import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepository bookRepository;

    public BootStrapData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Book Data");

        Book b1 = new Book();
        b1.setAuthor("Taras");
        b1.setTitle("Kobzar");
        b1.setInStockNumber(5);
        b1.setTakenBooksNumber(0);
        b1.setYear(1977);
        bookRepository.save(b1);

        Book b2 = new Book();
        b2.setAuthor("Taras Shevchenko");
        b2.setTitle("Zapovit");
        b2.setInStockNumber(8);
        b2.setTakenBooksNumber(0);
        b2.setYear(1978);
        bookRepository.save(b2);

        Book b3 = new Book();
        b3.setAuthor("Lesya Ukrainka");
        b3.setTitle("Contra Spem Spero");
        b3.setInStockNumber(3);
        b3.setTakenBooksNumber(0);
        b3.setYear(1978);
        bookRepository.save(b3);

        System.out.println("Books saved: " + bookRepository.count());


    }
}
