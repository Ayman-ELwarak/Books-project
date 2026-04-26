package com.global.hr.booksproject.controller;

import com.global.hr.booksproject.dto.AutherDto;
import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.mapper.AutherMapper;
import com.global.hr.booksproject.service.AutherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auther")
@Validated
@Tag(name = "Auther Management", description = "Operations related to Authers")
@RequiredArgsConstructor
public class AutherController {
    private final AutherService autherService;
    private final AutherMapper autherMapper;
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Auther> authers = autherService.findAll();
        return ResponseEntity.ok(authers);
    }

    @GetMapping("/spec")
    public ResponseEntity<?> findByAutherSpec(@RequestParam String name, @RequestParam String email){
        return ResponseEntity.ok(autherService.findByAutherSpec(name, email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Min(value = 1 ) Long id){
        Auther auther = autherService.findById(id);
        AutherDto autherDto = autherMapper.map(auther);
        return ResponseEntity.ok(autherDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        Auther auther = autherService.findByEmail(email);
        AutherDto autherDto = autherMapper.map(auther);
        return ResponseEntity.ok(autherDto);
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
