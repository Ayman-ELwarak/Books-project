package com.global.hr.booksproject.controller;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.service.AutherService;
import jakarta.validation.Valid;

import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auther")
@Validated
public class AutherController {
    private AutherService autherService;
    AutherController(AutherService autherService){
        this.autherService = autherService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(autherService.findAll());
    }

    @GetMapping("/spec")
    public ResponseEntity<?> findByAutherSpec(@RequestParam String name, @RequestParam String email){
        return ResponseEntity.ok(autherService.findByAutherSpec(name, email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Min(value = 1 ) Long id){
        return ResponseEntity.ok(autherService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> addAuther(@RequestBody @Valid Auther auther){
        return ResponseEntity.ok(autherService.insert(auther));
    }

    @PutMapping
    public ResponseEntity<?> updateAuther(@RequestBody @Valid Auther auther){
        return ResponseEntity.ok(autherService.update(auther));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteAuther(@PathVariable Long id){
        return ResponseEntity.ok(autherService.delete(id));
    }
}
