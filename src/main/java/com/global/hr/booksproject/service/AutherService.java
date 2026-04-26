package com.global.hr.booksproject.service;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.error.DaplicateRecordException;
import com.global.hr.booksproject.error.RecordNotFoundExecption;
import com.global.hr.booksproject.repository.AutherRepo;
import com.global.hr.booksproject.repository.AutherSpec;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutherService {
    private final AutherRepo autherRepo;

//    @Cacheable(value = "auther", key = "#root.methodName")
    public List<Auther> findAll(){
        return autherRepo.findAll();
    }

    public Auther findById(Long id){
        Optional<Auther> found = autherRepo.findById(id);
        if(found.isPresent()){
            return found.get();
        }else{
            throw new RecordNotFoundExecption("Auther Not Found");
        }
    }

    public Auther findByEmail(String email){
        return autherRepo.findByEmail(email);
    }

    public Auther getOne(Long id){
        return autherRepo.getReferenceById(id);
    }

    public Auther insert(Auther auther){
        String email = auther.getEmail();
        Auther found = autherRepo.findByEmail(email);
        if(found != null){
            log.error("Auther with email {} already exists", email);
            throw new DaplicateRecordException("Auther with email " + email + " already exists");
        }
        log.info("author email is {}, author name is {}", auther.getEmail(), auther.getName());
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
