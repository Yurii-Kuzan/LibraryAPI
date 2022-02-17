package com.softserveinc.cnh.libraryapi.validators.impl;

import com.softserveinc.cnh.libraryapi.dto.model.ReaderDTO;
import com.softserveinc.cnh.libraryapi.exceptions.ValidationException;
import com.softserveinc.cnh.libraryapi.validators.AbstractValidator;
import org.springframework.stereotype.Component;

@Component
public class ReaderDtoValidator extends AbstractValidator<ReaderDTO, Object> {

    @Override
    public void validate(ReaderDTO readerDTO) {
        if (readerDTO.getId() != null && readerDTO.getId() <= 0) {
            throw new ValidationException("Id is not correct");
        }
        if (readerDTO.getAge() != null && (readerDTO.getAge() < 16 || readerDTO.getAge() > 100)) {
            throw new ValidationException("Age is not correct");
        }
    }
}
