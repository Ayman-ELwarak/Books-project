package com.global.hr.booksproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.global.hr.booksproject.dto.BookDto;
import com.global.hr.booksproject.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "autherName", source = "auther.name")
    @Mapping(target = "auther", ignore = true)

    BookDto map(Book book);

    @Mapping(target = "auther.name", source = "autherName")
    @Mapping(target = "auther", ignore = true)
    Book unMap(BookDto bookDto);
}
