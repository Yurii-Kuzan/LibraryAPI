package com.softserveinc.cnh.libraryapi.dto.model;

import com.softserveinc.cnh.libraryapi.model.BookReader;
import lombok.Data;

import java.util.Set;

@Data
public class ReaderDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer age;
    private Set<BookReader> bookAssociation;
}
