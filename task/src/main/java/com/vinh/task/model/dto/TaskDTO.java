package com.vinh.task.model.dto;

import com.vinh.task.model.record.ProjectRecord;
import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO implements Serializable {
    public int task_id;
    public String task_name;
    public String task_description;
    public ProjectRecord project;
    private String message;

    // Các phương thức getter và setter cho trường message

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
