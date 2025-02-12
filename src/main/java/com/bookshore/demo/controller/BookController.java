package com.bookshore.demo.controller;

import com.bookshore.demo.models.BookModel;
import com.bookshore.demo.repositories.BookRepository;
import com.bookshore.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
