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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
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
    @Override
    public TaskDTO deleteTask(int id) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task deletedTask = taskOptional.get();
            taskRepository.deleteById(id);

            return createSuccessResponse(deletedTask);
        } else {
            return createNotFoundResponse(id);
        }
    }


    //create
    private TaskDTO createSuccessResponse(Task task) {
        TaskDTO response = new TaskDTO();
        response.setMessage("Project with ID " + task.getProject_id() + " has been deleted successfully.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }

    private TaskDTO createNotFoundResponse(int id) {
        TaskDTO response = new TaskDTO();
        response.setMessage("Project with ID " + id + " does not exist, so it cannot be deleted.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }
    @Override
    public Task updateTask(@RequestBody Task task, @PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();

            // Update the fields from the request, if provided
            if (task.getTask_name() != null) {
                existingTask.setTask_name(task.getTask_name());
            }
            if (task.getTask_description() != null) {
                existingTask.setTask_description(task.getTask_description());
            }
            if (task.getStart_date() != null) {
                existingTask.setStart_date(task.getStart_date());
            }
            if (task.getEnd_date() != null) {
                existingTask.setEnd_date(task.getEnd_date());
            }
                existingTask.setProject_id(task.getProject_id());


            // Save the updated task
            taskRepository.save(existingTask);
            return existingTask;
        } else {
            throw new NotFoundException("Task not found with id: " + id);
        }
    }


}
