package com.vinh.project.service;

import com.vinh.project.model.Project;
import com.vinh.project.model.dto.ProjectDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ProjectService {


    // find by id
    ProjectDTO findProjectById(int id);


//    ProjectDTO findProjectByIdOrName(String idOrName);

    List<ProjectDTO> findAllProject();


    ProjectDTO deleteProject(int id);

    Project updateProject(@RequestBody Project project, @PathVariable int id);
}
