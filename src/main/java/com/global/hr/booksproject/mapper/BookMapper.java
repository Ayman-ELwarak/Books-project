package com.global.hr.booksproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.global.hr.booksproject.dto.BookDto;
import com.global.hr.booksproject.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "autherName", source = "auther.name")
    BookDto map (Book book);

    @Mapping(target = "auther.name", source = "autherName")
    Book unMap (BookDto bookDto);
}
