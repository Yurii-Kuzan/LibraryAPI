package com.softserveinc.cnh.libraryapi.dto.mapper;

import com.softserveinc.cnh.libraryapi.dto.model.ReaderDTO;
import com.softserveinc.cnh.libraryapi.model.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReaderMapper {

    @Mapping(source = "id", target = "id")
    ReaderDTO readerToReaderDTO(Reader reader);
}
