package com.dhu.test4service.controller;

import com.dhu.test4service.dao.RoleAuthorRepository;
import com.dhu.test4service.pojo.Role;
import com.dhu.test4service.pojo.RoleAuthor;
import com.dhu.test4service.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "对于角色的操纵")
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("返回所有角色")
    @GetMapping(value = "/all")
    public List<Role> getAll()
    {
        return roleService.findAll();
    }

    @ApiOperation("添加角色")
    @GetMapping(value = "/add")
    public Role add(@RequestParam("name") String name)
    {
        Role role=new Role();
        role.setName(name);
        return roleService.save(role);
    }

    @ApiOperation("删除角色")
    @GetMapping(value = "/delete")
    public Integer delete(@RequestParam("id") int id)
    {
        return roleService.deleteById(id);
    }

    @ApiOperation("获取某个角色拥有的所有权限")
    @GetMapping(value = "/getAuthor")
    public List<RoleAuthor> getAuthor(@RequestParam("roleId") int roleId)
    {
        return roleService.findAuthorByRole(roleId);
    }

    @ApiOperation("为某个角色添加权限")
    @GetMapping(value = "/addAuthor")
    public RoleAuthor addAuthor(@RequestParam("roleId") int roleId, @RequestParam("authorId") int authorId)
    {
        return roleService.addRoleAuthor(roleId,authorId);
    }

    @ApiOperation("删除某角色的某权限")
    @GetMapping(value = "/delAuthor")
    public Integer  delAuthor(@RequestParam("roleId") int roleId, @RequestParam("authorId") int authorId)
    {
        return roleService.deleteRoleAuthor(roleId, authorId);
    }

    @ApiOperation("删除某角色的某权限-多态-只要传id")
    @GetMapping(value = "/deleteAuthor")
    public Integer  delAuthor(@RequestParam("id") int id)
    {
        return roleService.deleteRoleAuthorById(id);
    }
}
