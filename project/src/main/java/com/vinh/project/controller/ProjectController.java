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
@CrossOrigin(origins = "*")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectRepository projectRepository;



    @GetMapping("/project/{id}")
    public ProjectDTO findProjectById(@PathVariable int id){
        return projectService.findProjectById(id);
    }
    @GetMapping("/project/projectName/{idOrName}")
    public ProjectDTO findProjectByIdOrName(@PathVariable String idOrName){
        return projectService.findProjectByIdOrName(idOrName);
    }
    @GetMapping("/project")
    public List<ProjectDTO> findAllProject() {
        return projectService.findAllProject();
    }
    @PostMapping("/project") //create project
    public Project postProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }
    @DeleteMapping("/project/{id}")
    public ProjectDTO deleteProject(@PathVariable int id) {
        return projectService.deleteProject(id);
    }
    @PutMapping("/project/{id}")
    public Project updateProject(@RequestBody Project updatedProject, @PathVariable int id) {
        return projectService.updateProject(updatedProject, id);

    }



}
