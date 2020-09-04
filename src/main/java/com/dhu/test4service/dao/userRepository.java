package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface userRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findByNameAndPassword(String name, String password);

    User save(User user);

    User findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "update user set role=?2 where id=?1",nativeQuery = true)
    Integer updateUserRole(int id,int role);
}
