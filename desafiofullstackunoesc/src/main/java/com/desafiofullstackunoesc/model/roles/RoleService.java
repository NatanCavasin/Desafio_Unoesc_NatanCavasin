package com.desafiofullstackunoesc.model.roles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> getAllRoles(){
        return repository.findAll();
    }

}
