package com.softserveinc.cnh.libraryapi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookReaderId implements Serializable {
    private long book;
    private long reader;
}
