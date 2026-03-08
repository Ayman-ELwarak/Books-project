package com.global.hr.booksproject.service;

import com.global.hr.booksproject.entity.Book;
import com.global.hr.booksproject.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book findById(Long id){
        return bookRepo.findById(id).orElse(null);
    }

    public Book insert(Book book){
        return bookRepo.save(book);
    }

    public List<Book> insertAll(List<Book> books){
        return bookRepo.saveAll(books);
    }

    public Book update(Book book){
        Book found = findById(book.getId());
        if(found == null){
            return null;
        }

        return bookRepo.save(book);
    }

    public String delete(Long id){
        Book found = findById(id);
        if(found == null){
            return "User Not Found";
        }

        bookRepo.deleteById(id);
        return "User Deleted Successfully";
    }

    public int deleteByAuther(Long autherId){
        return bookRepo.deleteByAuther(autherId);
    }
}
