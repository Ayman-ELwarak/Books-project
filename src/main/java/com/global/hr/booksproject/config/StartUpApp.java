package com.global.hr.booksproject.config;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.entity.Book;
import com.global.hr.booksproject.service.AutherService;
import com.global.hr.booksproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableAspectJAutoProxy()
public class StartUpApp implements CommandLineRunner {
    @Autowired
    private AutherService autherService;

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        List<Auther> data = autherService.findAll();

        if(data.size() == 0){
            Auther a1 = new Auther();
            a1.setName("Ayman Khaled");
            Auther a2 = new Auther();
            a2.setName("Ahmed Khaled");
            Auther a3 = new Auther();
            a3.setName("Ehab Khaled");

            autherService.insertAll(List.of(a1, a2, a3));
        }

        List<Book> bookData = bookService.findAll();

        if(bookData.size() == 0){
            Book a1 = new Book();
            a1.setName("Java");
            a1.setPrice(200);
            a1.setAuther(autherService.getOne((long) 1));
            Book a2 = new Book();
            a2.setName("Spring");
            a2.setPrice(200);
            a2.setAuther(autherService.getOne((long) 2));

            bookService.insertAll(List.of(a1, a2));
        }

    }
}
