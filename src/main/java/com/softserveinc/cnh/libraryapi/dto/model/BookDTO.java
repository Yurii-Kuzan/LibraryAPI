package com.softserveinc.cnh.libraryapi.dto.model;

import com.softserveinc.cnh.libraryapi.model.BookReader;
import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private Integer inStockNumber;
    private Integer takenBooksNumber;
    private Set<BookReader> readerAssociation;
}
