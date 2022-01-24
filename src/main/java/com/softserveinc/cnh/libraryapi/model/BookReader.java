package com.softserveinc.cnh.libraryapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "book_reader")
@IdClass(BookReaderId.class)
public class BookReader {
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "reader_id", referencedColumnName = "id")
    private Reader reader;

    @Column(name = "date")
    private Date date;
}
