package com.vinh.task.service;

import com.vinh.task.controller.res.PagingResponse;
import com.vinh.task.model.Task;
import com.vinh.task.model.dto.TaskDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface TaskService {
    List<TaskDTO> findAllTask();

    TaskDTO findTaskById(int id);



    TaskDTO deleteTask(int id);


    Task updateTask(@RequestBody Task task, @PathVariable int id);
}
