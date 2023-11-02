package com.vinh.project.controller;

import com.vinh.project.model.Project;
import com.vinh.project.model.dto.ProjectDTO;
import com.vinh.project.repository.ProjectRepository;
import com.vinh.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAll")
    public List<ProjectDTO> getAllProject() {
        return projectService.findAllProject();
    }
    @PostMapping("/post") //create project
    public Project postMocktest(@RequestBody Project project) {
        return projectRepository.save(project);
    }

}
