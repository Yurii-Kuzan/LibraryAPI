package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.exceptions.ResourceNotFoundException;
import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.repositories.ReaderRepository;
import com.softserveinc.cnh.libraryapi.services.impl.ReaderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private ReaderServiceImpl readerService;

    @Test
    void findReaderById_ReaderReturned() {
        var idValue = 1L;
        var reader = Reader.builder().id(idValue).age(18).firstName("Yurii").build();

        when(readerRepository.findById(any())).thenReturn(java.util.Optional.of(reader));
        var returnedReader = readerService.findReaderById(idValue);

        assertEquals(returnedReader.getId(), idValue);

        verify(readerRepository).findById(any());
    }

    @Test
    void findReaderById_ReaderNotFoundCase() {
        var idValue = 1L;
        ResourceNotFoundException thrown = Assertions.assertThrows(ResourceNotFoundException.class, () -> readerService.findReaderById(idValue), "Reader with id " + idValue + " is not exist");
    }

    @Test
    void findAllReaders_ReadersReturned() {
        var idValue = 1L;
        var reader = Reader.builder().id(idValue).age(18).firstName("Yurii").build();

        var idValueSecond = 2L;
        var readerSecond = Reader.builder().id(idValueSecond).age(20).firstName("Mikhailo").build();

        var readers = new ArrayList<Reader>();
        readers.add(reader);
        readers.add(readerSecond);

        when(readerRepository.findAll()).thenReturn(readers);
        var returnedReaders = readerService.findAllReaders();

        assertNotNull(returnedReaders);
        assertEquals(returnedReaders.size(), 2);
        assertEquals(returnedReaders.get(0), reader);

        verify(readerRepository).findAll();
    }

    @Test
    void findAllReaders_ReturnedEmptyReadersList() {
        var readers = new ArrayList<Reader>();

        when(readerRepository.findAll()).thenReturn(readers);
        var returnedReaders = readerService.findAllReaders();

        assertTrue(returnedReaders.isEmpty());

        verify(readerRepository).findAll();
    }


    @Test
    void findReaderByAge_ReadersReturned() {
        var idValue = 1L;
        var reader = Reader.builder().id(idValue).age(18).firstName("Yurii").build();
        var readers = new ArrayList<Reader>();
        readers.add(reader);

        when(readerRepository.findReaderByAge(any())).thenReturn(readers);
        var returnedReaders = readerService.findReaderByAge(18);

        assertEquals(returnedReaders.get(0), reader);
        verify(readerRepository).findReaderByAge(18);
    }

    @Test
    void findReaderByAge_ReturnedEmptyReadersList() {
        var readers = new ArrayList<Reader>();

        when(readerRepository.findReaderByAge(any())).thenReturn(readers);
        var returnedReaders = readerService.findReaderByAge(18);

        assertTrue(returnedReaders.isEmpty());

        verify(readerRepository).findReaderByAge(18);
    }

    @Test
    void findReaderByAddress_ReadersReturned() {
        var idValue = 1L;
        var reader = Reader.builder().id(idValue).age(18).firstName("Yurii").address("Pushkinska 79").build();
        var readers = new ArrayList<Reader>();
        readers.add(reader);

        when(readerRepository.findReaderByAddress(any())).thenReturn(readers);
        var returnedReaders = readerService.findReaderByAddress("Pushkinska 79");

        assertEquals(returnedReaders.get(0), reader);
        verify(readerRepository).findReaderByAddress("Pushkinska 79");
    }

    @Test
    void findReaderByAddress_ReturnedEmptyReaderList() {
        var readers = new ArrayList<Reader>();

        when(readerRepository.findReaderByAddress(any())).thenReturn(readers);
        var returnedReaders = readerService.findReaderByAddress("Pushkinska 79");

        assertTrue(returnedReaders.isEmpty());

        verify(readerRepository).findReaderByAddress("Pushkinska 79");
    }

    @Test
    void findReaderByName_ReadersReturned() {
        var idValue = 1L;
        var reader = Reader.builder().id(idValue).age(18).firstName("Yurii").build();
        var readers = new ArrayList<Reader>();
        readers.add(reader);

        when(readerRepository.findReaderByName(any())).thenReturn(readers);
        var returnedReaders = readerService.findReaderByName("Yurii");

        assertEquals(returnedReaders.get(0), reader);
        verify(readerRepository).findReaderByName("Yurii");
    }

    @Test
    void findReaderByName_ReturnedEmptyReadersList() {
        var readers = new ArrayList<Reader>();

        when(readerRepository.findReaderByName(any())).thenReturn(readers);
        var returnedReaders = readerService.findReaderByName("Yurii");

        assertTrue(returnedReaders.isEmpty());
        verify(readerRepository).findReaderByName("Yurii");
    }

    @Test
    void saveReader_ReaderSaved() {
        var idValue = 1L;
        var reader = Reader.builder().id(idValue).age(18).firstName("Yurii").build();


        when(readerRepository.save(any())).thenReturn(reader);
        Reader returnedReader = readerService.saveReader(reader);

        assertEquals(returnedReader.getId(), idValue);
        verify(readerRepository).save(reader);
    }

    @Test
    void deleteReaderById_ReaderDeleted() {
        var idValue = 1L;

        readerService.deleteReaderById(idValue);
        verify(readerRepository).deleteById(idValue);
    }
}