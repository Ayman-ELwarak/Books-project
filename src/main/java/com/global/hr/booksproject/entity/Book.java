package com.global.hr.booksproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.hr.booksproject.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Should be enter book")
    private String name;

    @Min(value = 5000)
    @Max(value = 100000)
    private double price;

    @Transient
    private double discounted;

    @Formula("(select count(*) from books)")
    private Long bookCount;

    @ManyToOne()
    @JoinColumn(name = "auther_id")
    @JsonBackReference
    @NotNull
    private Auther auther;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }

    public double getDiscounted() {
        return discounted;
    }

    public void setDiscounted(double discounted) {
        this.discounted = discounted;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    @PostLoad
    private void calcDiscount(){
        this.setDiscounted(price * .25);
    }
}
