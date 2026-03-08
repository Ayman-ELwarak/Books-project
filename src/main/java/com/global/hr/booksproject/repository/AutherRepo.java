package com.global.hr.booksproject.repository;

import com.global.hr.booksproject.base.BaseRepo;
import com.global.hr.booksproject.entity.Auther;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface AutherRepo extends BaseRepo<Auther, Long>, JpaSpecificationExecutor<Auther> {
}
