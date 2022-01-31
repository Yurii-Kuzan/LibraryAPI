package com.softserveinc.cnh.libraryapi.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Throwable cause){super(cause);}

    public ResourceNotFoundException(String message){super(message);}
}
