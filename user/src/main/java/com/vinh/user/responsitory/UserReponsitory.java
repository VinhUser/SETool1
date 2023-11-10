package com.vinh.user.responsitory;

import com.vinh.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableJpaRepositories
@Repository
@Service
public interface UserReponsitory extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByUsername(String username);
    Boolean existsByPhone(Integer phone);
    List<User> findAll();
}
