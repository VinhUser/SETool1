package com.vinh.project.service.impl;

import com.vinh.project.client.GroupClient;
import com.vinh.project.model.Project;
import com.vinh.project.model.dto.ProjectDTO;
import com.vinh.project.repository.ProjectRepository;
import com.vinh.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GroupClient groupClient;

    // find by id
    @Override
    public ProjectDTO findProjectById(int id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            return null; // hoặc xử lý nếu không tìm thấy project
        }

        ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);

        try {
            projectDTO.setGroup(groupClient.getGroup(project.getGroup_id()));
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu cần thiết
        }

        return projectDTO;
    }

//    @Override
//    public ProjectDTO findProjectByIdOrName(String idOrName) {
//        Project project = null;
//
//        try {
//            // Thử tìm dự án bằng ID trước
//            int id = Integer.parseInt(idOrName);
//            project = projectRepository.findById(id).orElse(null);
//        } catch (NumberFormatException e) {
//            // Nếu idOrName không phải là số, nó có thể là tên, bạn có thể thực hiện tìm kiếm bằng tên ở đây
//            project = projectRepository.findByName(idOrName);
//        }
//
//        if (project == null) {
//            return null; // hoặc xử lý nếu không tìm thấy project
//        }
//
//        ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
//
//        try {
//            projectDTO.setGroup(groupClient.getGroup(project.getGroup_id()));
//        } catch (Exception e) {
//            // Xử lý ngoại lệ nếu cần thiết
//        }
//
//        return projectDTO;
//    }


    //find all
    @Override
    public List<ProjectDTO> findAllProject() {
        List<ProjectDTO> projectDTOS = projectRepository.findAll().stream()
                .map(projectEntity -> {
                    ProjectDTO projectDTO = modelMapper.map(projectEntity, ProjectDTO.class);

                    try {
                        projectDTO.setGroup(groupClient.getGroup(projectEntity.getGroup_id()));
                    } catch (Exception e) {
                        // Xử lý ngoại lệ nếu cần thiết
                    }
                    return projectDTO;
                })
                .collect(Collectors.toList());

        return projectDTOS;
    }


    // delete
    @Override
    public ProjectDTO deleteProject(int id) {
        Optional<Project> projectOptional = projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            Project deletedProject = projectOptional.get();
            projectRepository.deleteById(id);

            return createSuccessResponse(deletedProject);
        } else {
            return createNotFoundResponse(id);
        }
    }


    //create
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

    @Override
    public Project updateProject(@RequestBody Project project, @PathVariable int id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project1 = optionalProject.get();
            List<Project> projectList = projectRepository.findAll();
            for (Project project2 : projectList) {

                project.setProject_id(project1.getProject_id());
                project.setProject_name(project.getProject_name());
                project.setProject_description(project.getProject_description());
                project.setStart_date(project.getStart_date());
                project.setEnd_date(project.getEnd_date());
                project.setGroup_id(project.getGroup_id());


                projectRepository.save(project);

            }
        }
        return project;
    }

}
