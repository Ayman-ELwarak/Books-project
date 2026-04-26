package com.global.hr.booksproject.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.hr.booksproject.base.BaseRepo;
import com.global.hr.booksproject.entity.Book;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepo extends BaseRepo<Book, Long> {
    @Query(value = "delete from Book where auther.id = :autherId")
    @Transactional
    @Modifying
    int deleteByAuther(Long autherId);
}
