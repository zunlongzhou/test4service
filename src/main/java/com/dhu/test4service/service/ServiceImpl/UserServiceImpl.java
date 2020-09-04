package com.dhu.test4service.service.ServiceImpl;


import com.dhu.test4service.dao.userRepository;
import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private userRepository userRepo;

    @Override
    public List<User> findAll()
    {
        return userRepo.findAll();
    }

    @Override
    public Integer findByNameAndPassword(String Name, String Password)
    {
        User user = userRepo.findByNameAndPassword(Name,Password);
        if(user==null){
            return -1;
        }
        return user.getRole();

    }

    @Override
    public User save(User user)
    {
        return userRepo.save(user);
    }

    @Override
    public Integer getRole(String Name)
    {
        User user=userRepo.findByName(Name);
        if(user==null){
            return -1;
        }
        return user.getRole();

    }

    @Override
    public Integer updateUserRole(int id,int role)
    {
        return userRepo.updateUserRole(id,role);
    }
}
