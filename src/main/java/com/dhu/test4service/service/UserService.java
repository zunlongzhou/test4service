package com.dhu.test4service.service;

import com.dhu.test4service.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByNameAndPassword(String Name, String Password);

    User save(User user);

    Integer getRole(String Name);

    Integer updateUserRole(int id,int role);
}
