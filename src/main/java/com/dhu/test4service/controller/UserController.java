package com.dhu.test4service.controller;

import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public Integer login(@RequestParam("name") String name, @RequestParam("password") String password)
    {
        return userService.findByNameAndPassword(name,password);
    }

    @GetMapping(value = "/register")
    public User register(@RequestParam("name") String name, @RequestParam("password") String password)
    {
        User user1=new User(name,password,1,1);
        return userService.save(user1);
    }

    @GetMapping("/role")
    public Integer getRole(@RequestParam("name") String name){
        Integer op=userService.getRole(name);
        return op;
    }
}
