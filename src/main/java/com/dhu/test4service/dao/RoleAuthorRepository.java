package com.dhu.test4service.dao;

import com.dhu.test4service.pojo.RoleAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleAuthorRepository extends JpaRepository<RoleAuthor,Integer> {
    List<RoleAuthor> findAll();
}
