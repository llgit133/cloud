package org.example.controller;


import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    //这里以RESTFul风格为例
    @RequestMapping("/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        return userService.getUserById(uid);
    }
}
