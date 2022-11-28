package com.example.service;

import com.example.model.Book;

import java.util.HashMap;
import java.util.Map;

public interface ICartService {
    Map<Book, Integer> bookMap = new HashMap<>();
}
