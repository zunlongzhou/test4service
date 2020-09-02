package com.dhu.test4service.controller;


import com.dhu.test4service.pojo.Authority;
import com.dhu.test4service.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "权限的相关操作")
@CrossOrigin
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @ApiOperation("返回所有权限")
    @GetMapping(value = "/all")
    public List<Authority> getAll()
    {
        return authorService.findAll();
    }

    @ApiOperation("添加一个新权限")
    @GetMapping(value = "/add")
    public Authority add(@RequestParam("power") String power)
    {
        Authority authority=new Authority();
        authority.setPower(power);
        return authorService.save(authority);
    }

    @ApiOperation("删除一个权限")
    @GetMapping(value = "/delete")
    public Integer delete(@RequestParam("id") int id)
    {
        return authorService.deleteById(id);
    }
}
