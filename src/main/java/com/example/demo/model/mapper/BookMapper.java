package com.example.demo.model.mapper;

import com.example.demo.model.dto.BookDto;
import com.example.demo.model.entity.Books;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto bookToBookDto(Books bookEntity);

    List<BookDto> bookToBookDto(List<Books> bookEntity);

}
