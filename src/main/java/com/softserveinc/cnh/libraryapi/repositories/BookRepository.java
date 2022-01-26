package com.softserveinc.cnh.libraryapi.repositories;

import com.softserveinc.cnh.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

/**
 * Change extended interface to prod example `cause of opportunity to use Optional
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query("select " +
            "b " +
            "from Book b " +
            "where b.year = :year"
    )
    List<Book> findBookByYear(@Param("year") Integer year);

    @Query(nativeQuery = true, value = "select " +
            "* " +
            "from book " +
            "where book.author = :author"
    )
    List<Book> findBookByAuthor(@Param("author") String author);

    List<Book> findBookByTitle(String title);
}
