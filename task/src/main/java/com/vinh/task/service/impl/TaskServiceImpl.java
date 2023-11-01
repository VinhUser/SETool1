package com.vinh.task.service.impl;

import com.vinh.task.client.ProjectClient;
import com.vinh.task.model.Task;
import com.vinh.task.model.dto.TaskDTO;
import com.vinh.task.repository.TaskRepository;
import com.vinh.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectClient projectClient;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TaskDTO> findAllTask() {
        List<TaskDTO> taskDTOS = taskRepository.findAll().stream()
                .map(taskEntity -> {
                    TaskDTO taskDTO = modelMapper.map(taskEntity, TaskDTO.class);

                    try {
                        taskDTO.setProject(projectClient.getProject(taskEntity.getProject_id()));
                    } catch (Exception e) {
                        // Xử lý ngoại lệ nếu cần thiết
                    }
                    return taskDTO;
                })
                .collect(Collectors.toList());

        return taskDTOS;
    }
    @Override
    public TaskDTO findTaskById(int id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return null; // hoặc xử lý nếu không tìm thấy công việc
        }

        TaskDTO taskDTO = modelMapper.map(task, TaskDTO.class);

        try {
            taskDTO.setProject(projectClient.getProject(task.getProject_id()));
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu cần thiết
        }

        return taskDTO;
    }

}
