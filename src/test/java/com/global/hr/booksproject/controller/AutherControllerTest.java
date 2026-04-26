package com.global.hr.booksproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.global.hr.booksproject.dto.AutherDto;
import com.global.hr.booksproject.entity.Auther;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AutherControllerTest {

    // @Autowired
    // MockMvc mockMvc;
    
    // @Test
    // public void FindByEmailTest() {
    //     String email = "ali@gmail.com";
    //     mockMvc.perform(get("/auther/email/{email}", email)
	//             .contentType("application/json"))
	//             // .param("sendWelcomeMail", "true")
	//             // .content(objectMapper.writeValueAsString(new Auther("Ali", "19.2.125.52", "ali@gmail.com", 0, null))))
	// 	      .andExpect(status().isOk());
    // }
}
