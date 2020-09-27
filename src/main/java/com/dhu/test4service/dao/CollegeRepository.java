package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College,Integer> {

    List<College> findAll();
}
