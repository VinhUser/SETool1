package com.vinh.submissionTest.model.dto;

import com.vinh.submissionTest.model.record.TaskRecord;
import com.vinh.submissionTest.model.record.UserRecord;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmissionTaskDTO implements Serializable {
    private int submission_task_id;

    public TaskRecord task;

    public UserRecord user;

    public Date Submission_date;

    public String content;
    public String message;
}
