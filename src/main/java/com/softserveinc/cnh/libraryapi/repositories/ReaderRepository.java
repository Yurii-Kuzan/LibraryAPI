package com.softserveinc.cnh.libraryapi.repositories;

import com.softserveinc.cnh.libraryapi.model.Book;
import com.softserveinc.cnh.libraryapi.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    List<Reader> findReaderByAddress(String address);

    @Query("select " +
            "r " +
            "from Reader r " +
            "where r.age = :age"
    )
    List<Reader> findReaderByAge(@Param("age") Integer age);

    @Query(nativeQuery = true, value = "select " +
            "* " +
            "from reader " +
            "where reader.first_name = :name"
    )
    List<Reader> findReaderByName(@Param("name") String name);
}
