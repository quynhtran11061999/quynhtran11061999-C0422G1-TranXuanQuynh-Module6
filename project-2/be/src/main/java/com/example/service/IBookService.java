package com.example.service;

import com.example.dto.IBookDto;
import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Optional<Book> findBookById(Long id);

    Page<Book> findByTitle(String tittle, Pageable pageable);
}
