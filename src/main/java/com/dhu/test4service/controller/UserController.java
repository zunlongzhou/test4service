package com.dhu.test4service.controller;

import com.dhu.test4service.dao.RoleAuthorRepository;
import com.dhu.test4service.dao.RoleRepository;
import com.dhu.test4service.pojo.Role;
import com.dhu.test4service.pojo.RoleAuthor;
import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        User user1=new User(name,password,2,null,null,null);
        return userService.save(user1);
    }

    @GetMapping("/role")
    public Integer getRole(@RequestParam("name") String name){
        Integer op=userService.getRole(name);
        return op;
    }

    @GetMapping(value = "/admin")
    public List<User> UserInfo(){
        List<User> list=userService.findAll();
        for(int i=0;i<list.size();i++){
            list.get(i).setPassword(null);
            switch (list.get(i).getRole()){
                case 1:
                {
                    list.get(i).setPassword("管理员");
                    break;
                }
                case 2:
                {
                    list.get(i).setPassword("教师");
                    break;
                }
                case 3:
                {
                    list.get(i).setPassword("学生");
                    break;
                }
            }
        }

        return list;
    }
}
