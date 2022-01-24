package com.softserveinc.cnh.libraryapi.services;

import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService{

    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader findReaderById(Long id) {
        return readerRepository.getById(id);
    }

    @Override
    public List<Reader> findAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }

    @Override
    public List<Reader> findReaderByAge(Integer age) {
        return readerRepository.findReaderByAge(age);
    }

    @Override
    public List<Reader> findReaderByAddress(String address) {
        return readerRepository.findReaderByAddress(address);
    }

    @Override
    public List<Reader> findReaderByName(String name) {
        return readerRepository.findReaderByName(name);
    }
}
