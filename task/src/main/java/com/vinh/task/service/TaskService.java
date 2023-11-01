package com.vinh.task.service;

import com.vinh.task.controller.res.PagingResponse;
import com.vinh.task.model.dto.TaskDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskDTO> findAllTask();

    TaskDTO findTaskById(int id);
}
