package com.dhu.test4service.service.ServiceImpl;


import com.dhu.test4service.dao.AuthorRepository;
import com.dhu.test4service.pojo.Authority;
import com.dhu.test4service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Authority> findAll(){
        return authorRepository.findAll();
    }

    @Override
    public Authority save(Authority authority){
        return authorRepository.save(authority);
    }

    @Override
    public Integer deleteById(int id){
        Authority authority=authorRepository.findById(id);
        if(authority==null){
            return -1;
        }
        return authorRepository.deleteById(id);
    }

    @Override
    public Integer updatePowerById(int id,String power){
        Authority authority=authorRepository.findById(id);
        if(authority==null){
            return -1;
        }
        return authorRepository.updatePowerById(id,power);
    }
}
