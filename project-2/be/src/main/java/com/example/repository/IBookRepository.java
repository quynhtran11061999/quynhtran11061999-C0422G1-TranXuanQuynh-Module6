package com.example.repository;

import com.example.dto.IBookDto;
import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining(String tittle, Pageable pageable);
}
