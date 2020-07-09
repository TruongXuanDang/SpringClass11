package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public List<Role> getAll();

    void saveRole(Role role);
    void deleteRole(int id);
    Role findRoleById(int id);

}
