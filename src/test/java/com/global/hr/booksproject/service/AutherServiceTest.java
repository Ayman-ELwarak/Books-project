package com.global.hr.booksproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.repository.AutherRepo;

@SpringBootTest
public class AutherServiceTest {

    @Autowired
    private AutherService autherService;

    @MockBean
    private AutherRepo autherRepo;

    @Test
    public void findByEmailFoundTest() {

        Auther author = new Auther(
                null,
                "George R.R. Martin",
                "mail@gmail.com",
                "/path/to/img.png",
                "127.0.0.1",
                null,
                0L,
                false);

        Mockito.when(autherRepo.findByEmail("mail@gmail.com")).thenReturn(author);
        Auther auther = autherService.findByEmail("mail@gmail.com");
        assertEquals("mail@gmail.com", auther.getEmail());
    }
}
