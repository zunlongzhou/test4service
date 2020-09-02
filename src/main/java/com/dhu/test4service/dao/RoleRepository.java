package com.dhu.test4service.dao;

import com.dhu.test4service.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findAll();

    Role save(Role role);

    Integer deleteById(int id);

    Role findById(int id);
}
