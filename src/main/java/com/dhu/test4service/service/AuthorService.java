package com.dhu.test4service.service;

import com.dhu.test4service.pojo.Authority;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorService {

    List<Authority> findAll();

    Authority save(Authority authority);

    Integer deleteById(int id);

    Integer updatePowerById(int id,String power);
}
