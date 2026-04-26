package com.global.hr.booksproject.mapper;

import org.mapstruct.Mapper;

import com.global.hr.booksproject.dto.AutherDto;
import com.global.hr.booksproject.entity.Auther;

@Mapper(componentModel = "spring")
public interface AutherMapper {

    // convert Auther to AutherDto
    AutherDto map (Auther auther);

    // convert AutherDto to Auther
    Auther unMap (AutherDto autherDto);

}
