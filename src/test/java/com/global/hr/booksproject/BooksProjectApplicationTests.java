package com.global.hr.booksproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.service.AutherService;


@SpringBootTest
class BooksProjectApplicationTests {

    @Autowired
    private AutherService autherService;

    @Test
    void findByIdFoundTest() {
        Auther auther =  autherService.findById(1L);
        assertEquals(1L, auther.getId());
    }

}
