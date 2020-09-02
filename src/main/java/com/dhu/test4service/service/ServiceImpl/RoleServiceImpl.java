package com.dhu.test4service.service.ServiceImpl;

import com.dhu.test4service.dao.AuthorRepository;
import com.dhu.test4service.dao.RoleAuthorRepository;
import com.dhu.test4service.dao.RoleRepository;
import com.dhu.test4service.pojo.Authority;
import com.dhu.test4service.pojo.Role;
import com.dhu.test4service.pojo.RoleAuthor;
import com.dhu.test4service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RoleAuthorRepository roleAuthorRepository;

    @Override
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role){
        return roleRepository.save(role);
    }

    @Override
    public Integer deleteById(int id){
        Role role=roleRepository.findById(id);
        if(role==null){
            return -1;
        }
        return roleRepository.deleteById(id);
    }

    @Override
    public List<RoleAuthor> findAuthorByRole(int id){
        return roleAuthorRepository.findByRoleByRoleId(id);
    }

    @Override
    public RoleAuthor addRoleAuthor(int roleId,int authorId){
        Role role=roleRepository.findById(roleId);
        Authority author=authorRepository.findById(authorId);

        if(role==null||author==null){
            return null;
        }
        RoleAuthor roleAuthor=new RoleAuthor();
        roleAuthor.setRoleByRoleId(role);
        roleAuthor.setAuthorityByAuthorId(author);
        return roleAuthorRepository.save(roleAuthor);
    }
}
