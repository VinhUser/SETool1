package com.vinh.submissionTest.repository;

import com.vinh.submissionTest.model.SubmissionTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<SubmissionTask,Integer> {
}
