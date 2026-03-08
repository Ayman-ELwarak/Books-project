package com.global.hr.booksproject.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T extends BaseEntity, ID extends Number> extends JpaRepository<T, ID> {
    T findByName(String name);
}
