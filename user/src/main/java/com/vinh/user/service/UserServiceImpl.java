package com.vinh.user.service;

import com.vinh.user.dto.LoginDTO;
import com.vinh.user.dto.RegisterDTO;
import com.vinh.user.entity.User;
import com.vinh.user.responsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserReponsitory userReponsitory;

    @Override
    public User register(RegisterDTO registerDTO) {
        if (userReponsitory.existsByUsername(registerDTO.getUsername())) {
            throw new RuntimeException("Username already exists, please choose another username");
        }
        if (userReponsitory.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email already exists, please choose another email or reset your password");
        }

        User newUser = new User();
        newUser.setUsername(registerDTO.getUsername());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setPassword(registerDTO.getPassword());
        newUser.setRole("Student");
        userReponsitory.save(newUser);
        return newUser;
    }

    @Override
    public User login(LoginDTO loginDTO) {
        User user = userReponsitory.findByUsername(loginDTO.getUsername());

        if (user == null) {
            throw new RuntimeException("User not found. Please check your username.");
        }

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Incorrect password. Please check your password.");
        }

        return user;
    }
    @Override
    public User updateUserInformation(String username, String email, Integer phone, String password) {
        User user = userReponsitory.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        // Check for duplicate email or phone
        if (!user.getEmail().equals(email) && userReponsitory.existsByEmail(email)) {
            throw new RuntimeException("Email already exists, please choose another email.");
        }

        if (!user.getPhone().equals(phone) && userReponsitory.existsByPhone(phone)) {
            throw new RuntimeException("Phone number already exists, please choose another phone number.");
        }

        // Update user information
        user.setEmail(email);
        user.setPhone(phone);
        if (password != null) {
            user.setPassword(password);
        }

        userReponsitory.save(user);
        return user;
    }

    @Override
    public User getUserById(Integer userId) {
        return userReponsitory.findById( userId ).orElse( null );
    }
    @Override
    public List<User> findAllUsers() {
        return userReponsitory.findAll();
    }

}
