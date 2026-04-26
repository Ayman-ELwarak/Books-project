package com.global.hr.booksproject.repository;

import com.global.hr.booksproject.entity.Auther;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import java.util.ArrayList;
import java.util.List;

public class AutherSpec implements Specification<Auther> {
    private String autherName;
    private String autherEmail;

    public AutherSpec(String autherName, String autherEmail){
        super();
        this.autherName = autherName;
        this.autherEmail = autherEmail;
    }

    @Override
    public @Nullable Predicate toPredicate(@NonNull Root<Auther> root, @NonNull CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.like(root.get("name"), autherName));
        predicates.add(cb.like(root.get("email"), autherEmail));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
