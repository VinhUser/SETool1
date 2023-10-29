package com.vinh.moockTest.repository;

import com.vinh.moockTest.model.MockTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface moockTestRepository extends JpaRepository <MockTest, Integer> {
}
