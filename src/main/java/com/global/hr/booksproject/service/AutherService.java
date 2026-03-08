package com.global.hr.booksproject.service;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.repository.AutherRepo;
import com.global.hr.booksproject.repository.AutherSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutherService {
    @Autowired
    private AutherRepo autherRepo;

    public List<Auther> findAll(){
        return autherRepo.findAll();
    }

    public Auther findById(Long id){
        return autherRepo.findById(id).orElse(null);
    }

    public Auther getOne(Long id){
        return autherRepo.getReferenceById(id);
    }

    public Auther insert(Auther auther){
        return autherRepo.save(auther);
    }

    public List<Auther> insertAll(List<Auther> authers){
        return autherRepo.saveAll(authers);
    }

    public Auther update(Auther auther){
        Auther found = findById(auther.getId());
        if(found == null){
            return null;
        }

        return autherRepo.save(auther);
    }

    public String delete(Long id){
        Auther found = findById(id);
        if(found == null){
            return "User Not Found";
        }

        autherRepo.deleteById(id);
        return "User Deleted Successfully";
    }

    public List<Auther> findByAutherSpec(String autherName, String autherEmail){
        AutherSpec spec = new AutherSpec(autherName, autherEmail);

        return autherRepo.findAll(spec);
    }

}
