package com.example.demo.service;

import com.example.demo.model.dto.BookDto;
import com.example.demo.model.mapper.BookMapper;
import com.example.demo.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper mapper;

    @Override
    public List<BookDto> getBookList(String firstChar) {
        if (firstChar == null) {
            return mapper.bookToBookDto(bookRepository.findAll());
        }
        return mapper.bookToBookDto(bookRepository.findByNameStartingWithIgnoreCase(firstChar));
    }

    @Override
    public Map<String, Integer> getBookCounts() {
        Map<String, Integer> map = new HashMap<>();
        List<Object[]> list = bookRepository.findCountOfBook();
        list.forEach(l -> map.put((String) l[0], ((BigInteger) l[1]).intValue()));
        return map;
    }
}
