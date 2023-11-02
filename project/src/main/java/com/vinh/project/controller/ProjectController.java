package com.vinh.project.controller;

import com.vinh.project.model.Project;
import com.vinh.project.model.dto.ProjectDTO;
import com.vinh.project.repository.ProjectRepository;
import com.vinh.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<ProjectDTO> findAllProject() {
        return projectService.findAllProject();
    }
    @PostMapping("/post") //create project
    public Project postMocktest(@RequestBody Project project) {
        return projectRepository.save(project);
    }
    @DeleteMapping("delete/{id}")
    public ProjectDTO deleteProject(@PathVariable int id) {
        Optional<Project> projectOptional = projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            Project deletedProject = projectOptional.get();
            projectRepository.deleteById(id);

            return createSuccessResponse(deletedProject);
        } else {
            return createNotFoundResponse(id);
        }
    }

    private ProjectDTO createSuccessResponse(Project deletedProject) {
        ProjectDTO response = new ProjectDTO();
        response.setMessage("Project with ID " + deletedProject.getProject_id() + " has been deleted successfully.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }

    private ProjectDTO createNotFoundResponse(int id) {
        ProjectDTO response = new ProjectDTO();
        response.setMessage("Project with ID " + id + " does not exist, so it cannot be deleted.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }


}
