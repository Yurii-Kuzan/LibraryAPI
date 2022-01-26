package com.softserveinc.cnh.libraryapi.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Throwable cause){super(cause);}

    public BookNotFoundException(String message){super(message);}
}
