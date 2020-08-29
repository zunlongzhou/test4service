package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findAll();
}
