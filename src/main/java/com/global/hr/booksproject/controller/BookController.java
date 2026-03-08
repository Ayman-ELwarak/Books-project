package com.global.hr.booksproject.controller;

import com.global.hr.booksproject.entity.Book;
import com.global.hr.booksproject.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
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
