package com.global.hr.booksproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.hr.booksproject.base.BaseEntity;
import com.global.hr.booksproject.validator.IpAddress;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "authers")
@SQLDelete(sql = "update authers set is_deleted = true where id = ?")
@SQLRestriction("is_deleted = false")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "image-path")
    private String imagePath;

    @Column(name = "ip-address")
    @IpAddress(message = "Should be a ip address")
    private String ipAddress;

    @OneToMany(mappedBy = "auther")
    @JsonManagedReference
    private List<Book> books;

    @Formula("(select count(*) from books b where b.auther_id = id)")
    private Long bookCount;

    private boolean isDeleted;
}
