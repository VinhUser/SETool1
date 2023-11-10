package com.vinh.user.service;

import com.vinh.user.dto.LoginDTO;
import com.vinh.user.dto.RegisterDTO;
import com.vinh.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    User register(RegisterDTO registerDTO);
    User login(LoginDTO loginDTO);

    User updateUserInformation(String username, String email, Integer phone, String password);
    User getUserById(Integer userId);
    List<User> findAllUsers();
}
