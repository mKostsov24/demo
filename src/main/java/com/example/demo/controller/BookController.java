package com.example.demo.controller;

import com.example.demo.model.dto.BookDto;
import com.example.demo.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @GetMapping("/list")
    public List<BookDto> getBookList(@RequestParam(required = false) String firstChar) {
        return bookService.getBookList(firstChar);
    }

    @GetMapping("/count")
    public Map<String, Integer> getCount() {
        return bookService.getBookCounts();
    }
}
