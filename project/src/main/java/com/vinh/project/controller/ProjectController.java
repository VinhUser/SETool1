package com.vinh.project.controller;

import com.vinh.project.model.Project;
import com.vinh.project.repository.ProjectRepository;
import com.vinh.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectRepository projectRepository;



    @GetMapping("/project/{id}")
    public Project project(@PathVariable int id) {
        return projectRepository.findById(id).orElse(null);
    }

}
