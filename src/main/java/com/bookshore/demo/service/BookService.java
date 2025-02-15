package com.bookshore.demo.service;

import com.bookshore.demo.models.BookModel;
import com.bookshore.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<BookModel>> listAllBooks(){


        List<BookModel> booksList = bookRepository.findAll();

        //HATEOAS
//        if (!booksList.isEmpty()){
//            for (BookModel book: booksList){
//                UUID id = book.getIdBook();
//
//                book.add(linkTo(methodOn(BookController.class).findBookById(id)).withSelfRel());
//            }
//        }

        return ResponseEntity.status(HttpStatus.OK).body(booksList);

    }


    public ResponseEntity<Object> findByIdBook(@PathVariable(value ="id") UUID id){

        Optional<BookModel> book = bookRepository.findById(id);

        if (book.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BAD REQUEST");
        }

        return ResponseEntity.status(HttpStatus.OK).body(book.get());

    }

}
