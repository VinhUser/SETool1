package com.vinh.project.repository;

import com.vinh.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectRepository extends JpaRepository<Project, Integer> {
}
