package com.global.hr.booksproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.hr.booksproject.base.BaseEntity;
import com.global.hr.booksproject.validator.IpAddress;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "authers")
@SQLDelete(sql = "update authers set is_deleted = true where id = ?")
@SQLRestriction("is_deleted = false")
public class Auther extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "ip-address")
    @IpAddress(message = "Should be a ip address")
    private String ipAddress;

    @OneToMany(mappedBy = "auther")
    @JsonManagedReference
    private List<Book> books;

    @Formula("(select count(*) from books b where b.auther_id = id)")
    private Long bookCount;

    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void deleteBook(Book book){
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
