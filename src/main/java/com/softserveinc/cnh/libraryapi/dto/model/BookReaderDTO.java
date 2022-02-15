package com.softserveinc.cnh.libraryapi.dto.model;

import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.model.Reader;
import lombok.Data;

import java.util.Date;

@Data
public class BookReaderDTO {
    private Book book;
    private Reader reader;
    private Date date;
}
