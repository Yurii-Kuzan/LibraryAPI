package com.softserveinc.cnh.libraryapi.dto.mapper;

import com.softserveinc.cnh.libraryapi.dto.model.ReaderDTO;
import com.softserveinc.cnh.libraryapi.model.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReaderMapper {

    ReaderDTO readerToReaderDTO(Reader reader);
}
