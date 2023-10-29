package com.vinh.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private int projectId;
    private String projectName;
    private String projectDescription;
    private Date startDate;
    private Date endDate;
    private int groupId;
}
