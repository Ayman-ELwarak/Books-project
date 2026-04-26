package com.global.hr.booksproject.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.global.hr.booksproject.entity.Auther;

@SpringBootTest
public class AutherRepoTest {

    @Autowired
    private AutherRepo autherRepo;

    @Test
    void findByEmailNotFoundTest() {
        Auther auther =  autherRepo.findByEmail("mail@gmail.com");
        assertEquals(null, auther);
    }

}
