package com.softserveinc.cnh.libraryapi.services.impl;

import com.softserveinc.cnh.libraryapi.dto.model.ReaderDTO;
import com.softserveinc.cnh.libraryapi.exceptions.ResourceNotFoundException;
import com.softserveinc.cnh.libraryapi.model.Reader;
import com.softserveinc.cnh.libraryapi.repositories.ReaderRepository;
import com.softserveinc.cnh.libraryapi.services.ReaderService;
import com.softserveinc.cnh.libraryapi.specification.ReaderSpecification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader findReaderById(Long id) {
        return readerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Reader with id " + id + " is not exist"));
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
    public List<Reader> filterReaders(ReaderDTO readerDTO) {
        if (readerDTO.getId() != null) {
            List<Reader> singleReaderList = new ArrayList<>();
            singleReaderList.add(findReaderById(readerDTO.getId()));
            return singleReaderList;
        }
        Map<String, Object> attributes = new HashMap<>();
        if (readerDTO.getAge() != null) {
            attributes.put("age", readerDTO.getAge());
        }
        if (readerDTO.getAddress() != null) {
            attributes.put("address", readerDTO.getAddress());
        }
        if (readerDTO.getFirstName() != null) {
            attributes.put("first_name", readerDTO.getFirstName());
        }
        ReaderSpecification readerSpecification = ReaderSpecification.create(attributes);
        return readerRepository.findAll(readerSpecification);
    }
}
