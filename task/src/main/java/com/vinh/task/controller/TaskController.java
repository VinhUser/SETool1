package com.vinh.task.controller;

import com.vinh.task.model.Task;
import com.vinh.task.model.dto.TaskDTO;
import com.vinh.task.repository.TaskRepository;
import com.vinh.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/task")
    public List<TaskDTO> findAllTask1() {
        return taskService.findAllTask();
    }
    @GetMapping("/task/{id}")
    public TaskDTO findTaskById(@PathVariable int id) {
        return taskService.findTaskById(id);
    }
    @PostMapping("/task") //create project
    public Task postTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @DeleteMapping("/task/{id}")
    public TaskDTO deleteTask(@PathVariable int id){
        return taskService.deleteTask(id);
    }
    @PutMapping("/task/{id}")
    Task updateTask(@RequestBody Task task, @PathVariable int id){
        return taskService.updateTask(task, id);
    }
}
