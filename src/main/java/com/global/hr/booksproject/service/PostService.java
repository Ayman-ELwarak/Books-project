package com.global.hr.booksproject.service;

import com.global.hr.booksproject.entity.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {
    @Autowired
    private RestTemplate restTemplate;
    private String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    public PostDto getPostById(Long id){
        ResponseEntity<PostDto> rslt =  restTemplate.getForEntity(BASE_URL + "/" + id, PostDto.class);
        return rslt.getBody();
    }
}
