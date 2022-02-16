package com.softserveinc.cnh.libraryapi.dto.mapper;

import com.softserveinc.cnh.libraryapi.dto.model.BookReaderDTO;
import com.softserveinc.cnh.libraryapi.model.BookReader;
import org.mapstruct.Mapper;

@Mapper
public interface BookReaderMapper {

    BookReaderDTO toBookReaderDTO(BookReader bookReader);
}
