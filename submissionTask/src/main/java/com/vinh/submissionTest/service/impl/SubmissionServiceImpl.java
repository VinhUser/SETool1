package com.vinh.submissionTest.service.impl;

import com.vinh.submissionTest.client.TaskClient;
import com.vinh.submissionTest.client.UserClient;
import com.vinh.submissionTest.model.SubmissionTask;
import com.vinh.submissionTest.model.dto.SubmissionTaskDTO;
import com.vinh.submissionTest.repository.SubmissionRepository;
import com.vinh.submissionTest.service.SubmissionTaskService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubmissionServiceImpl implements SubmissionTaskService {
    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    TaskClient taskClient;
    @Autowired
    UserClient userClient;
    @Override
    public List<SubmissionTaskDTO> findAllTask() {
        List<SubmissionTaskDTO> submissionTaskDTOS = submissionRepository.findAll().stream()
                .map(submissionTaskEntity -> {
                    SubmissionTaskDTO submissionTaskDTO = modelMapper.map(submissionTaskEntity, SubmissionTaskDTO.class);

                    try {
                        submissionTaskDTO.setTask(taskClient.getTask(submissionTaskEntity.getTask_id()));
                        submissionTaskDTO.setUser(userClient.getUser(submissionTaskEntity.getUser_id()));
                    } catch (Exception e) {
                        // Xử lý ngoại lệ nếu cần thiết
                    }
                    return submissionTaskDTO;
                })
                .collect(Collectors.toList());

        return submissionTaskDTOS;
    }
    @Override
    public SubmissionTaskDTO findSubmissionTaskById(int id) {
        SubmissionTask submissionTask = submissionRepository.findById(id).orElse(null);
        if (submissionTask == null) {
            return null; // hoặc xử lý nếu không tìm thấy kết quả
        }

        SubmissionTaskDTO submissionTaskDTO = modelMapper.map(submissionTask, SubmissionTaskDTO.class);

        try {
            submissionTaskDTO.setUser(userClient.getUser(submissionTask.getUser_id()));
            submissionTaskDTO.setTask(taskClient.getTask(submissionTask.getTask_id()));

        } catch (Exception e) {
            // Xử lý ngoại lệ nếu cần thiết
        }

        return submissionTaskDTO;
    }
    @Override
    public SubmissionTaskDTO deleteSubmissionTask(int id) {
        Optional<SubmissionTask> submissionTaskOptional = submissionRepository.findById(id);

        if (submissionTaskOptional.isPresent()) {
            SubmissionTask deletedSubmissionTask = submissionTaskOptional.get();
            submissionRepository.deleteById(id);

            return createSuccessResponse(deletedSubmissionTask);
        } else {
            return createNotFoundResponse(id);
        }
    }


    //create
    private SubmissionTaskDTO createSuccessResponse(SubmissionTask submissionTask) {
        SubmissionTaskDTO response = new SubmissionTaskDTO();
        response.setMessage("Project with ID " + submissionTask.getSubmission_task_id() + " has been deleted successfully.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }

    private SubmissionTaskDTO createNotFoundResponse(int id) {
        SubmissionTaskDTO response = new SubmissionTaskDTO();
        response.setMessage("Project with ID " + id + " does not exist, so it cannot be deleted.");
        // Thêm các thông tin khác bạn muốn đưa vào response
        return response;
    }
    @Override
    public SubmissionTask updateSubmissionTask(SubmissionTask updatedSubmissionTask, int id) {
        Optional<SubmissionTask> optionalSubmissionTask = submissionRepository.findById(id);
        if (optionalSubmissionTask.isPresent()) {
            SubmissionTask existingSubmissionTask = optionalSubmissionTask.get();
            List<SubmissionTask> submissionTaskList = submissionRepository.findAll();

            for (SubmissionTask submissionTask : submissionTaskList) {
                if (submissionTask.getTask_id() == updatedSubmissionTask.getTask_id()
                        && submissionTask.getSubmission_task_id() != id) {
                    throw new IllegalArgumentException("This SubmissionTask is duplicated with Submission Task ID " + submissionTask.getSubmission_task_id() + "!, Update fail!");
                }
            }

            existingSubmissionTask.setSubmission_date(updatedSubmissionTask.getSubmission_date());
            existingSubmissionTask.setContent(updatedSubmissionTask.getContent());

            return submissionRepository.save(existingSubmissionTask);
        } else {
            throw new IllegalArgumentException("SubmissionTask with ID " + id + " does not exist, so it cannot be updated.");
        }
    }

}
