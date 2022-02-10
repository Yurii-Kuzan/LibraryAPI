package com.softserveinc.cnh.libraryapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private Integer year;

    @Column(name = "in_stock_number")
    private Integer inStockNumber;

    @Column(name = "taken_books_number")
    private Integer takenBooksNumber;

    @OneToMany(mappedBy = "reader")
    private Set<BookReader> readerAssociation = new HashSet<>();

}

