package com.global.hr.booksproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.booksproject.dto.BookDto;
import com.global.hr.booksproject.entity.Book;
import com.global.hr.booksproject.mapper.BookMapper;
import com.global.hr.booksproject.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Book book = bookService.findById(id);
        BookDto bookDto = bookMapper.map(book);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book){
        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody @Valid Book book){
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.delete(id));
    }

    @DeleteMapping("/auther/{autherId}")
    public int deleteByBook(@PathVariable Long autherId){
        return bookService.deleteByAuther(autherId);
    }

}
