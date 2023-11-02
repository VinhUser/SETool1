package com.vinh.project.service.impl;

import com.vinh.project.client.GroupClient;
import com.vinh.project.model.dto.ProjectDTO;
import com.vinh.project.repository.ProjectRepository;
import com.vinh.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


}
