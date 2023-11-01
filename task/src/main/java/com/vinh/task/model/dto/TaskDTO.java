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
}
