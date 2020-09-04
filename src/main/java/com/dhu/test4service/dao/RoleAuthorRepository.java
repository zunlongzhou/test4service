package com.dhu.test4service.dao;

import com.dhu.test4service.pojo.RoleAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoleAuthorRepository extends JpaRepository<RoleAuthor,Integer> {
    List<RoleAuthor> findAll();

    @Transactional
    @Modifying
    @Query(value = "select * from role_author where role_id=?1",nativeQuery = true)
    List<RoleAuthor> findByRoleByRoleId(int roleByRoleId);

    RoleAuthor save(RoleAuthor roleAuthor);

    @Transactional
    @Modifying
    @Query(value = "delete from role_author where role_id=?1 and author_id=?2",nativeQuery = true)
    Integer deleteByRoleAuthor(int roleId,int authorId);

    Integer deleteById(int id);
}
