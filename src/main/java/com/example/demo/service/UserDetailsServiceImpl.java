package com.example.demo.service;


import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.example.demo.entity.User u = userRepository.findByUsername(s);
        if(u!=null){
            User users = new User(u.getUsername(),u.getPassword(), Collections.emptySet());
            return users;
        }
        throw new UsernameNotFoundException(s);
    }
}
