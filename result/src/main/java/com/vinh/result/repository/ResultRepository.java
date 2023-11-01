package com.vinh.result.repository;

import com.vinh.result.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
//    @Query("SELECT r.ResultId, r.Comment, r.mock_test_id FROM result r")
//    List<Object[]> findAllResults();

}
