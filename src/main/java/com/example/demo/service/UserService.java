package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAll();

    void saveUser(User user);
    void deleteUser(int id);
    Optional<User> findUserById(int id);
}
