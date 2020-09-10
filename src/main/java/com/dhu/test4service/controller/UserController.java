package com.dhu.test4service.controller;

import com.dhu.test4service.dao.RoleAuthorRepository;
import com.dhu.test4service.dao.RoleRepository;
import com.dhu.test4service.pojo.Role;
import com.dhu.test4service.pojo.RoleAuthor;
import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.RoleService;
import com.dhu.test4service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户及账户相关操作")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ApiOperation("用户登录")
    @GetMapping(value = "/login")
    public User login(@RequestParam("name") String name, @RequestParam("password") String password)
    {
        return userService.findByNameAndPassword(name,password);
    }

    @ApiOperation("用户注册")
    @GetMapping(value = "/register")
    public User register(@RequestParam("name") String name, @RequestParam("password") String password,@RequestParam("role")int role)
    {
        User user1=new User(name,password,role,null,null,null);
        return userService.save(user1);
    }

    @ApiOperation("获取用户角色")
    @GetMapping("/role")
    public Integer getRole(@RequestParam("name") String name){
        Integer op=userService.getRole(name);
        return op;
    }

    @ApiOperation("获取用户权限")
    @GetMapping("/author")
    public List<RoleAuthor> getAuthor(@RequestParam("name") String name){
        Integer op=userService.getRole(name);
        return roleService.findAuthorByRole(op);
    }

    @ApiOperation("获取所有用户基本信息")
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
                case 4:
                {
                    list.get(i).setPassword("游客");
                    break;
                }
            }
        }

        return list;
    }

    @ApiOperation("更新用户角色")
    @GetMapping(value = "/uprole")
    public Integer updateUserRole(@RequestParam("id") int id,@RequestParam("role") int role)
    {
        return userService.updateUserRole(id,role);
    }

    @ApiOperation("更新用户姓名")
    @GetMapping(value = "/upname")
    public Integer updateUserName(@RequestParam("id") int id,@RequestParam("name") String name)
    {
        return userService.updateUserName(id,name);
    }

    @ApiOperation("更新用户密码")
    @GetMapping(value = "/uppwd")
    public Integer updateUserPassword(@RequestParam("id") int id,@RequestParam("password") String password)
    {
        return userService.updateUserPassword(id,password);
    }

    @ApiOperation("更新用户电话")
    @GetMapping(value = "/uptel")
    public Integer updateUserTel(@RequestParam("id") int id,@RequestParam("tel") String tel)
    {
        return userService.updateUserTel(id,tel);
    }

    @ApiOperation("更新用户邮箱")
    @GetMapping(value = "/upmailbox")
    public Integer updateUserMailbox(@RequestParam("id") int id,@RequestParam("mailbox") String mailbox)
    {
        return userService.updateUserMailbox(id,mailbox);
    }

    @ApiOperation("更新用户地址")
    @GetMapping(value = "/upaddress")
    public Integer updateUserRole(@RequestParam("id") int id,@RequestParam("address") String address)
    {
        return userService.updateUserAddress(id,address);
    }



}
