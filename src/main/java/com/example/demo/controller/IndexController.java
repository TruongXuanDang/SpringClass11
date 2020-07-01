package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        List<User> lsUser = userService.getAll();
        System.out.println("Size: "+lsUser.size());
        model.addAttribute("hello","truong");
        model.addAttribute("lsUser",lsUser);
        return "hello";
    }
}
