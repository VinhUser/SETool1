package com.vinh.task.controller;

import com.vinh.task.model.dto.TaskDTO;
import com.vinh.task.repository.TaskRepository;
import com.vinh.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/get")
    public List<TaskDTO> findAllTask1() {
        return taskService.findAllTask();
    }
    @GetMapping("/get/{id}")
    public TaskDTO findTaskById(int id) {
        return taskService.findTaskById(id);
    }
}
