package com.bookshore.demo.repositories;

import com.bookshore.demo.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID>{

    BookModel findBookModelByTitle(String title);

    @Query(value = "SELECT * FROM tbl_book WHERE publisher_ID = :id", nativeQuery = true)
    List<BookModel> findBooksByPublisher(@Param("id") UUID id);

    @Query(value = "SELECT * FROM tbl_book_autor WHERE autor_ID = :id", nativeQuery = true)
    List<BookModel> findBooksByAutorID(@Param("id") UUID id);

}


