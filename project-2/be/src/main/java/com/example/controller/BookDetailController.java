package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class BookDetailController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> bookDetail(@PathVariable Long id) {

        Book book = this.iBookService.findByIdBook(id);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
