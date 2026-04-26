package com.global.hr.booksproject.controller;

import com.global.hr.booksproject.entity.PostDto;
import com.global.hr.booksproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id")  Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
}
