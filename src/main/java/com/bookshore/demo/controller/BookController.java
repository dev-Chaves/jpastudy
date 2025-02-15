package com.bookshore.demo.controller;

import com.bookshore.demo.models.BookModel;
import com.bookshore.demo.repositories.BookRepository;
import com.bookshore.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/consultar")
    public ResponseEntity<List<BookModel>> listAllBooks(){
        return bookService.listAllBooks();
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<Object> findBookById (@PathVariable(value = "id")UUID id) { return bookService.findByIdBook(id);}

}
