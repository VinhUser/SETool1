package com.vinh.project.repository;

import com.vinh.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "SELECT * FROM project p WHERE p.project_name = :projectName", nativeQuery = true)
    Project findByName(@Param("projectName") String projectName);
}
