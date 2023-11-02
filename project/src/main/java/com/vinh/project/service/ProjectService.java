package com.vinh.project.service;

import com.vinh.project.model.dto.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {


    List<ProjectDTO> findAllProject();


}
