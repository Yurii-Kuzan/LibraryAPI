package com.softserveinc.cnh.libraryapi.facade;

import com.softserveinc.cnh.libraryapi.services.BookReaderService;
import com.softserveinc.cnh.libraryapi.services.BookService;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BookReaderFacade {

  //  private final BookService bookService;
    //private final ReaderService readerService;
   // private final BookReaderService bookReaderService;

public int takeBook(Long bookId, Long readerId){
    return 1;
}

}
