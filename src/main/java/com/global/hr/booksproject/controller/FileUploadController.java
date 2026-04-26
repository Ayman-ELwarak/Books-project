package com.global.hr.booksproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.global.hr.booksproject.service.FileUploadService;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam Long id, @RequestParam String path, @RequestParam MultipartFile file) {
        return ResponseEntity.ok(fileUploadService.storeFile(fileUploadService.convertMultiPartFileToFile(file), id, path));
    }
}
