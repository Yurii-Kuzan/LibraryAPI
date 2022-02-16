package com.softserveinc.cnh.libraryapi.dto.mapper;

import com.softserveinc.cnh.libraryapi.dto.model.BookDTO;
import com.softserveinc.cnh.libraryapi.model.Book;
import org.mapstruct.Mapper;


@Mapper
public interface BookMapper {

    BookDTO toBookDTO(Book book);
}
