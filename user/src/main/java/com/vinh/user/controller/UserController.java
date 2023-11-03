package com.vinh.user.controller;

import com.vinh.user.model.User;
import com.vinh.user.repository.UserRepository;
import com.vinh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }
}
