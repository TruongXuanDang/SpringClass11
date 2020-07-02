package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserValidator;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "addUser";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        new UserValidator().validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        else {
            userService.saveUser(user);
            return "redirect:/hello";
        }
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam("id") int userId, Model model){
        Optional<User> userEdit = userService.findUserById(userId);
        userEdit.ifPresent(user->model.addAttribute("user",user));
        return "editUser";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update (@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        new UserValidator().validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        else {
            userService.saveUser(user);
            return "redirect:/hello";
        }
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") int userId, Model model){
        userService.deleteUser(userId);
        return "redirect:/hello";
    }
}
