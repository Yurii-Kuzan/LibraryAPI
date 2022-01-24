package com.softserveinc.cnh.libraryapi.repositories;

import com.softserveinc.cnh.libraryapi.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }

    /**
     * The test needs script-file for filling the db and check fields after
     */

    @Test
    void findBookByTitle() {
        List<Book> bookTestList = bookRepository.findBookByTitle("Kobzar");

        assertEquals("Kobzar", bookTestList.get(1).getTitle());
    }
}