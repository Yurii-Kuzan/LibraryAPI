package com.softserveinc.cnh.libraryapi.validators;

public abstract class AbstractValidator<T, U> {

    public void validate(T t) {
        throw new UnsupportedOperationException("Method is not implemented!");
    }

    public U doValidate(T t) {
        throw new UnsupportedOperationException("Method is not implemented!");
    }

}