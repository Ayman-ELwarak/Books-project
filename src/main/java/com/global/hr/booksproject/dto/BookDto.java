package com.global.hr.booksproject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.hr.booksproject.entity.Auther;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter 
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;

    @NotNull(message = "Should be enter book")
    private String name;

    @Min(value = 5000)
    @Max(value = 100000)
    private double price;


    private Long bookCount;

    private String autherName;

}
