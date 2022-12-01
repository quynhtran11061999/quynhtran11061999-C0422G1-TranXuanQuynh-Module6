package com.example.controller;

import com.example.dto.IBookDto;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class BookRestController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/shop")
    public ResponseEntity<Page<IBookDto>> bookShop(@RequestParam Optional<String> title,
                                                   @RequestParam Optional<String> author,
                                                   @PageableDefault(size = 8) Pageable pageable) {
        String titles = title.orElse("");
        String authors = author.orElse("");

        Page<IBookDto> bookList = this.iBookService.findAllBookAndSearch(titles, authors, pageable);

        if (!bookList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
