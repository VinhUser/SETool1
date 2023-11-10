package com.vinh.user.controller;

import com.vinh.user.dto.LoginDTO;
import com.vinh.user.dto.RegisterDTO;
import com.vinh.user.dto.UpdateUserDTO;
import com.vinh.user.entity.User;
import com.vinh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User register(@RequestBody RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();
        String email = registerDTO.getEmail();
        String password = registerDTO.getPassword();
        Integer phone = registerDTO.getPhone();
        return userService.register(registerDTO); // Remove the unnecessary code inside the register method.
    }
    @PostMapping("/login")
    public User login(@RequestBody LoginDTO loginDTO) {
        return userService.login( loginDTO );
    }
    @PostMapping("/update")
    public User updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        String username = updateUserDTO.getUsername();
        String email = updateUserDTO.getEmail();
        Integer phone = updateUserDTO.getPhone();
        String password = updateUserDTO.getPassword();
        return userService.updateUserInformation(username, email, phone, password);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById( userId );
        if (user != null) {
            return new ResponseEntity<>( user, HttpStatus.OK );
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

}
