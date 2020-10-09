package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.College;
import com.dhu.test4service.pojo.RoleAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College,Integer> {

    List<College> findAll();

//    @Transactional
//    @Query(value = "select * from college where name=?1",nativeQuery = true)
    College findByName(String name);

}
