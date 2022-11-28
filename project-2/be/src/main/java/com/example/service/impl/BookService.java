package com.example.service.impl;

import com.example.dto.IBookDto;
import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<IBookDto> findAllBookAndSearch(String title, String author, Pageable pageable) {
        return this.iBookRepository.findAllBookAndSearch(
                "%" + title + "%",
                "%" + author + "%",
                pageable
        );
    }

    @Override
    @Transactional
    public Book findByIdBook(Long id) {
        return this.iBookRepository.findByIdBook(id);
    }
}
