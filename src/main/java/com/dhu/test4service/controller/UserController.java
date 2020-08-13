package com.dhu.test4service.controller;

import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public User register(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("apartment") Integer apartment, @RequestParam("role") Integer role)
    {
        User user1=new User(name,password,apartment,role);
        return userService.save(user1);
    }

    @GetMapping("/role")
    public String getRole(@RequestParam("name") String name){
        Integer op=userService.getRole(name);
        switch (op)
        {
            case -1:
            {
                return "fail";
            }
            case 1:
            {
                return "role1";
            }
            case 2:
            {
                return "role2";
            }
            case 3:
            {
                return "role3";
            }
        }
        return "fail";
    }
}
