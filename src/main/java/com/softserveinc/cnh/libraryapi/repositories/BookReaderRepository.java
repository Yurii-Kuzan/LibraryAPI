package com.softserveinc.cnh.libraryapi.repositories;

import com.softserveinc.cnh.libraryapi.model.BookReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReaderRepository extends JpaRepository<BookReader, Long>, JpaSpecificationExecutor<BookReader> {
    List<BookReader> findBookReadersByReader(Long readerId);

    List<BookReader> findBookReadersByBook(Long bookId);

}
