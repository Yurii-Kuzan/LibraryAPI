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

        var b1 = Book.builder().author("Taras").title("Kobzar")
                .inStockNumber(5).takenBooksNumber(0).year(1977).build();
        bookRepository.save(b1);

        var b2 = Book.builder().author("Taras Shevchenko").title("Zapovit")
                .inStockNumber(8).takenBooksNumber(0).year(1978).build();
        bookRepository.save(b2);

        var b3 = Book.builder().author("Lesya Ukrainka").title("Contra Spem Spero")
                .inStockNumber(3).takenBooksNumber(0).year(1978).build();
        bookRepository.save(b3);

        System.out.println("Books saved: " + bookRepository.count());


    }
}
