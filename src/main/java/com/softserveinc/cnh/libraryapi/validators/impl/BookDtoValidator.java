package com.softserveinc.cnh.libraryapi.validators.impl;

import com.softserveinc.cnh.libraryapi.dto.model.BookDTO;
import com.softserveinc.cnh.libraryapi.exceptions.ValidationException;
import com.softserveinc.cnh.libraryapi.validators.AbstractValidator;
import org.springframework.stereotype.Component;

@Component
public class BookDtoValidator extends AbstractValidator<BookDTO, Object> {

    @Override
    public void validate(BookDTO bookDTO) {
        if (bookDTO.getId() != null && bookDTO.getId() <= 0) {
            throw new ValidationException("Id is not correct");
        }
        if (bookDTO.getYear() != null && (bookDTO.getYear() < 1600 || bookDTO.getYear() > 2022)) {
            throw new ValidationException("Year is not correct");
        }
    }

}
