package com.dhu.test4service.dao;

import com.dhu.test4service.pojo.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Authority,Integer> {

    List<Authority> findAll();

    Authority save(Authority authority);

    Integer deleteById(int id);

    Authority findById(int id);

    @Transactional
    @Modifying
    @Query(value = "update authority set power = ?2 where id = ?1",nativeQuery = true)
    Integer updatePowerById(int id,String power);

}
