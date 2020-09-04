package com.dhu.test4service.service;

import com.dhu.test4service.pojo.Authority;
import com.dhu.test4service.pojo.Role;
import com.dhu.test4service.pojo.RoleAuthor;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role save(Role role);

    Integer deleteById(int id);

    List<RoleAuthor> findAuthorByRole(int id);

    RoleAuthor addRoleAuthor(int roleId,int authorId);

    Integer deleteRoleAuthor(int roleId,int authorId);

    Integer deleteRoleAuthorById(int id);
}
