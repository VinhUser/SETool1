package com.vinh.mockTest.repository;

import com.vinh.mockTest.model.MockTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockTestRepository extends JpaRepository <MockTest, Integer> {
}
