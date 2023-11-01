package com.vinh.task.repository;

import com.vinh.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<Task, Integer> {
}
