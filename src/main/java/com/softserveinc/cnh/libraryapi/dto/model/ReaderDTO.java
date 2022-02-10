package com.softserveinc.cnh.libraryapi.dto.model;

import com.softserveinc.cnh.libraryapi.model.BookReader;
import lombok.Data;

import java.util.Set;

@Data
public class ReaderDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer year;
    private Set<BookReader> bookAssociation;
}
