package com.dhu.test4service.service;

import com.dhu.test4service.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    Boolean findByNameAndPassword(String Name, String Password);

    User save(User user);

    Integer getRole(String Name);
}
