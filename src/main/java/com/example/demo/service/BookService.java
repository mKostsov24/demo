package com.example.demo.service;

import com.example.demo.model.dto.BookDto;

import java.util.List;
import java.util.Map;


public interface BookService {

    List<BookDto> getBookList(String name);

    Map<String, Integer> getBookCounts();
}
